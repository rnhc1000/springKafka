package br.dev.ferreiras.kafka.json_consumer.listener;

import br.dev.ferreiras.kafka.json_consumer.model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class JsonListener {


  public static final Logger logger = LoggerFactory.getLogger(JsonListener.class);

  @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
  public void antiFraud(@Payload Payment payment) throws InterruptedException {
    Thread.sleep(2000);

    logger.info("Payment received {}", payment.toString());
    Thread.sleep(2000);

    logger.info("FRAUD VALIDATOR ::: Validating payment data...");
    Thread.sleep(200);

  }

  @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
  public void pdfGenerator(@Payload Payment payment) throws InterruptedException {
    Thread.sleep(8000);

    logger.info("FRAUD VALIDATOR ::: Generating PDF payment id...{}", payment.getId());
    Thread.sleep(3000);

  }

  @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
  public void sendEmail() throws InterruptedException {
    Thread.sleep(12000);

    logger.info("FRAUD VALIDATOR ::: Sending email...");


  }
}
