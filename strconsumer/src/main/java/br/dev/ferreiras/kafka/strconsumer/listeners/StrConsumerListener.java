package br.dev.ferreiras.kafka.strconsumer.listeners;

import br.dev.ferreiras.kafka.strconsumer.custom.StrConsumerCustomListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

@Component
public class StrConsumerListener {

  private static final Logger logger = LoggerFactory.getLogger(StrConsumerListener.class);

//  @KafkaListener(groupId = "group-one",
//      topicPartitions = {
//          @TopicPartition(topic = "str-topic", partitions = {"0"})
//      }, containerFactory = "concurrentKafkaListenerContainerFactory")
  @StrConsumerCustomListener(groupId = "group-one")
  public void crete(String message) {

    logger.info("CREATE ::: Receive message {}", message);
  }

//  @KafkaListener(groupId = "group-one",
//      topicPartitions = {
//          @TopicPartition(topic = "str-topic", partitions = {"1"})
//      }, containerFactory = "concurrentKafkaListenerContainerFactory")
  @StrConsumerCustomListener(groupId = "group-one")
  public void log(String message) {

    logger.info("LOG ::: Receive message {}", message);
  }

  @StrConsumerCustomListener(groupId = "group-two")
  public void history(String message) {

    logger.info("HISTORY ::: Receive message {}", message);
  }
}
