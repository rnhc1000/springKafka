package br.dev.ferreiras.kafka.strproducer.services;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StringProducerService {

  private final KafkaTemplate<String, String> kafkaTemplate;

  private static final Logger logger = LoggerFactory.getLogger(StringProducerService.class);
  public StringProducerService(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(String message) {
    logger.info("Send message {}", message);
    kafkaTemplate.send("str-topic", message);
//        .thenAccept(success -> {
//          if( success != null ) {
//            logger.info("Message sent! {}", message);
//            logger.info("Partition {}, Offset {}", success.getRecordMetadata().partition(), success.getRecordMetadata().offset());
//
//          }
//        })
//        .exceptionally(error -> {
//              logger.error("Unable to send message=[{}] due to : {}", message, error.getMessage());
//              return null;
//            }
//        );
  }

}
