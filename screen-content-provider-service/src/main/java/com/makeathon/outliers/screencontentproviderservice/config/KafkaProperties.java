package com.makeathon.outliers.screencontentproviderservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kafka")
@Data
public class KafkaProperties {

  private String confluentBootstrapAddress;
  private String confluentApiKey;
  private String confluentSecret;
  private String bootstrapAddress;
  private String clientId;
  private String groupId;
  private String topic;
  private String securityProtocol;

  String getJaasConfig() {
    return String.format(
        "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"%s\" password=\"%s\" ;",
        this.confluentApiKey, confluentSecret);
  }

}
