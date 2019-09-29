package com.makeathon.outliers.scheduleservice.service;

import com.makeathon.outliers.scheduleservice.config.KafkaProperties;
import com.makeathon.outliers.scheduleservice.entity.Booking;
import com.makeathon.outliers.scheduleservice.model.BookingEntries;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@AllArgsConstructor
@Slf4j
public class BookingPublisher {
  private KafkaTemplate<String, BookingEntries> kafkaTemplate;
  private KafkaProperties kafkaProperties;

  void publishMessage(BookingEntries bookings) {
    log.info("Sending payload with Booking ID= {} to topic {}", bookings.getBookingList().stream().findFirst().get().getId(), kafkaProperties.getTopic());

    final ListenableFuture<SendResult<String, BookingEntries>> future = kafkaTemplate
        .send(kafkaProperties.getTopic(), bookings);

    future.addCallback(new ListenableFutureCallback<SendResult<String, BookingEntries>>() {

      @Override
      public void onFailure(Throwable ex) {
        log.error("Error sending booking to topic {} Exception : {} ", kafkaProperties.getTopic(), ex);
      }

      @Override
      public void onSuccess(SendResult<String, BookingEntries> result) {
        log.info("Sent message with offset= {}", result.getRecordMetadata().offset());
      }
    });
  }
}
