package br.dev.ferreiras.kafka.paymentservice.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.io.Serializable;
import java.util.Map;

@Configuration
public class JsonProducerConfig {

  private final KafkaProperties kafkaProperties;

  public JsonProducerConfig(KafkaProperties kafkaProperties) {
    this.kafkaProperties = kafkaProperties;
  }

  @Bean
  public ProducerFactory jsonProducerFactory() {

    Map<String, Object> configs = Map.of (
        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers(),
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class
    );

    return new DefaultKafkaProducerFactory(configs, new StringSerializer(), new JsonSerializer());
  }

  @Bean
  public KafkaTemplate<String, Serializable> josnKafkaTemplate(ProducerFactory jsonProducerFactory) {

    return new KafkaTemplate<>(jsonProducerFactory);
  }
}
