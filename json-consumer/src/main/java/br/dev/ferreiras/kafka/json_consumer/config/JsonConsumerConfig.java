package br.dev.ferreiras.kafka.json_consumer.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.converter.BatchMessageConverter;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@Configuration
public class JsonConsumerConfig {

  private final KafkaProperties kafkaProperties;

  public JsonConsumerConfig(KafkaProperties kafkaProperties) {
    this.kafkaProperties = kafkaProperties;
  }

  @Bean
  public ConsumerFactory<String, Object> jsonConsumerFactory() {

    Map<String, Object> configs = Map.of(
        ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers(),
        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class
    );
    return new DefaultKafkaConsumerFactory<>(configs);
  }
//
//  @Bean
//  public ConcurrentKafkaListenerContainerFactory jsonContainerFactory(
//      ConsumerFactory<String, Object> jsonConsumerFactory
//  ) {
//
//    var factory = new ConcurrentKafkaListenerContainerFactory<String, Object>();
//    factory.setConsumerFactory(jsonConsumerFactory);
//    factory.
//
//    return factory;
//  }

  @Bean
  KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Object>>
  jsonContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, Object> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(jsonConsumerFactory());
    factory.setConcurrency(3);
    factory.getContainerProperties().setPollTimeout(3000);

    return factory;
  }
}
