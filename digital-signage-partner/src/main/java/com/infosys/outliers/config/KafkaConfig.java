package com.infosys.outliers.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class KafkaConfig {
	
	@Value(value = "${kafka.bootstrap-address:127.0.0.1:9092}")
    protected String bootstrapAddress;
}
