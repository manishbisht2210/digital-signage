package com.makeathon.outliers.contentnotifier.config;

import com.tenx.dub.subscription.event.v1.SubscriptionEvent;
import java.time.Duration;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;

@Configuration
public class KafkaConfig {

  @Bean("subscriptionsReceiver")
  KafkaReceiver<String, SubscriptionEvent> subscriptionsReceiver(KafkaProperties kafkaProperties,
      @Value("${kafka-receiver.commit-interval-ms}") int commitIntervalMs,
      @Value("${subscriptionTopic}") String topic) {
    return KafkaReceiver.create(ReceiverOptions.<String, SubscriptionEvent>create(kafkaProperties.buildConsumerProperties())
      .commitInterval(Duration.ofMillis(commitIntervalMs))
      .subscription(Collections.singleton(topic)));
  }

}
