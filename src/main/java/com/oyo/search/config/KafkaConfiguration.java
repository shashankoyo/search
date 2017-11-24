package com.oyo.search.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Configuration
@EnableKafka
@Component
@EnableScheduling
@ConditionalOnProperty("kafka.enabled")
public class KafkaConfiguration {

	private static final Logger log = LoggerFactory.getLogger(KafkaConfiguration.class);

	@Value("${kafka.bootstrap.server}")
	private String bootstrapServer;

	@Value("${kafka.consumer.groupId}")
	private String consumerGroup;

	@Value("${kafka.consumer.concurrency:5}")
	private String kafkaConcurrency;

	public Map<String, Object> consumerConfigs() {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroup);
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 30000);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return props;
	}

	@Bean
	public ConsumerFactory<Object, Object> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfigs());
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Object, Object> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.setConcurrency(Integer.parseInt(kafkaConcurrency));
		return factory;
	}

}
