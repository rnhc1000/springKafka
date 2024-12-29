package br.dev.ferreiras.kafka.paymentservice.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import java.util.Map;

@Configuration
public class KafkaAdminConfig {

  private final KafkaProperties kafkaProperties;

  public KafkaAdminConfig(KafkaProperties kafkaProperties) {
    this.kafkaProperties = kafkaProperties;
  }

  @Bean
  public KafkaAdmin kafkaAdmin() {
    Map<String, Object> configs = Map.of(
        AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers()
    );
    return new KafkaAdmin(configs);
  }

  @Bean
  public KafkaAdmin.NewTopics newTopics() {
    return new KafkaAdmin.NewTopics(
        TopicBuilder.name("payment-topic").partitions(1).build()
    );
  }


}
