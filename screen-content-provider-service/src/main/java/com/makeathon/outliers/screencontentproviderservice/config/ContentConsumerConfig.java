package com.makeathon.outliers.screencontentproviderservice.config;

import static org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.CLIENT_ID_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.CONNECTIONS_MAX_IDLE_MS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.receiver.internals.ConsumerFactory;
import reactor.kafka.receiver.internals.DefaultKafkaReceiver;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ContentConsumerConfig {

  private final KafkaProperties kafkaProperties;
  private KafkaReceiver kafkaReceiver;

  @Bean
  public KafkaReceiver<String, String> kafkaReceiver() {
    Map<String, Object> properties = new HashMap<>();

    properties.put(BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapAddress());
    properties.put(CLIENT_ID_CONFIG, kafkaProperties.getClientId());
    properties.put(GROUP_ID_CONFIG,  kafkaProperties.getGroupId());
    properties.put(ENABLE_AUTO_COMMIT_CONFIG, false);
    properties.put(AUTO_OFFSET_RESET_CONFIG, "latest");
    properties.put(CONNECTIONS_MAX_IDLE_MS_CONFIG, TimeUnit.DAYS.toMillis(1));
    properties.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    properties.put(VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

    properties.put("ssl.endpoint.identification.algorithm", "https");
    properties.put("sasl.mechanism", "PLAIN");
    properties.put("request.timeout.ms", "20000");
    properties.put("retry.backoff.ms", "500");
    properties.put("sasl.jaas.config", kafkaProperties.getJaasConfig());
    properties.put("security.protocol", kafkaProperties.getSecurityProtocol());

    ReceiverOptions<Object, Object> consumerOptions = ReceiverOptions.create(properties)
        .subscription(Collections.singleton("unconfirmed-transactions"))
        .addAssignListener(partitions -> log.debug("onPartitionsAssigned {}", partitions))
        .addRevokeListener(partitions -> log.debug("onPartitionsRevoked {}", partitions));

    kafkaReceiver = KafkaReceiver.create(consumerOptions);
    return kafkaReceiver;
  }

}
