package br.dev.ferreiras.kafka.strconsumer.listeners;

import br.dev.ferreiras.kafka.strconsumer.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.stereotype.Component;
@Component
public class StrConsumerListener {

  private static final Logger logger = LoggerFactory.getLogger(StrConsumerListener.class);

  @KafkaListener(groupId = "group-one",
      topicPartitions = {
          @TopicPartition(topic = "str-topic", partitions = {"0"})
      }, containerFactory = "concurrentKafkaListenerContainerFactory")
  @StrConsumerCustomListener(groupId = "group-one")
  public void create(String message) throws ListenerExecutionFailedException {

    logger.info("CREATE ::: Receive message {}", message);

    throw new IllegalArgumentException("EXCEPTION");
  }

  @KafkaListener(groupId = "group-one",
      topicPartitions = {
          @TopicPartition(topic = "str-topic", partitions = {"1"})
      }, containerFactory = "concurrentKafkaListenerContainerFactory")
@StrConsumerCustomListener(groupId = "group-one")
  public void log(String message)  throws ListenerExecutionFailedException {

    try {
      logger.info("LOG ::: Receive message {}", message);
    } catch(Exception ex) {
      throw new IllegalArgumentException(("EXCEPTION"));
    }
  }

//  @KafkaListener(groupId = "group-two", containerFactory = "validMessageContainerFactory", topics = "str-topic")
//  public void history(String message) {
//
//    logger.info("HISTORY ::: Receive message {}", message);
//  }

}
