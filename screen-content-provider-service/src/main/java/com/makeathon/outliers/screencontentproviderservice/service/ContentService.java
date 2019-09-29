package com.makeathon.outliers.screencontentproviderservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.makeathon.outliers.screencontentproviderservice.model.BookingEntries;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverRecord;

@Service
public class ContentService {

  @Autowired
  KafkaReceiver<String,String> kafkaReceiver;

  private ObjectMapper objectMapper = new ObjectMapper();

  public Flux<String> streamFluxContent() {

    Flux<ReceiverRecord<String,String>> kafkaFlux = kafkaReceiver.receive();

    return kafkaFlux.log().doOnNext( r -> {
      final BookingEntries bookingEvent = fromBinary((String) r.value(), BookingEntries.class);
      r.receiverOffset().acknowledge();
    } )
        .map(ReceiverRecord::value);

  }

  private <T> T fromBinary(String object, Class<T> resultType) {
    try {
      return objectMapper.readValue(object, resultType);
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }

}
