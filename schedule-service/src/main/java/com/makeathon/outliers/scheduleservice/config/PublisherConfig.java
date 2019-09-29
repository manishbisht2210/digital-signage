package com.makeathon.outliers.scheduleservice.config;

import static org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.CLIENT_ID_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.makeathon.outliers.scheduleservice.model.BookingEntries;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
@AllArgsConstructor
public class PublisherConfig {

  private final KafkaProperties kafkaProperties;

  private Map<String, Object> producerConfig() {
    Map<String, Object> properties = new HashMap<>();

    properties.put(BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getConfluentBootstrapAddress());
    properties.put(CLIENT_ID_CONFIG, kafkaProperties.getClientId());
    properties.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    properties.put(VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    properties.put("ssl.endpoint.identification.algorithm", "https");
    properties.put("sasl.mechanism", "PLAIN");
    properties.put("request.timeout.ms", "20000");
    properties.put("retry.backoff.ms", "500");
    properties.put("sasl.jaas.config", kafkaProperties.getJaasConfig());
    properties.put("security.protocol", kafkaProperties.getSecurityProtocol());

    return properties;
  }

  @Bean
  @Autowired
  public KafkaTemplate kafkaTemplate(@Qualifier("publisherObjectMapper") ObjectMapper objectMapper) {
    DefaultKafkaProducerFactory<String, BookingEntries> kafkaProducerFactory = new DefaultKafkaProducerFactory<>(
        producerConfig());

    kafkaProducerFactory.setValueSerializer(new JsonSerializer<>(objectMapper));
    return new KafkaTemplate<>(kafkaProducerFactory);
  }
}
