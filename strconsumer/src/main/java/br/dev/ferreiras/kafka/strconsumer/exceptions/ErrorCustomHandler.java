package br.dev.ferreiras.kafka.strconsumer.exceptions;

import lombok.SneakyThrows;
import org.apache.kafka.clients.consumer.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {

  private static final Logger logger = LoggerFactory.getLogger(ErrorCustomHandler.class);

  @Override
  public Object handleError( Message<?> message, ListenerExecutionFailedException exception) {
    logger.info("EXCEPTION HANDLER ::: An error occurred ");
    logger.info("Payload ::: {}", message.getPayload());
    logger.info("Headers ::: {}", message.getHeaders());
    return null;
  }

//  @Override
//  public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
//    return KafkaListenerErrorHandler.super.handleError(message, exception, consumer);
//  }
//
//  @Override
//  public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer, Acknowledgment ack) {
//    return KafkaListenerErrorHandler.super.handleError(message, exception, consumer, ack);
//  }
}
