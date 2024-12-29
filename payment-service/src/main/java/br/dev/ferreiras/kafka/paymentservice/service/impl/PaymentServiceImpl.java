package br.dev.ferreiras.kafka.paymentservice.service.impl;

import br.dev.ferreiras.kafka.paymentservice.model.Payment;
import br.dev.ferreiras.kafka.paymentservice.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class PaymentServiceImpl implements PaymentService {
  /**
   * @param payment
   */

  private final KafkaTemplate<String, Serializable> kafkaTemplate;

  private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

  public PaymentServiceImpl(KafkaTemplate<String, Serializable> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @Override
  public void sendPayment(Payment payment) throws InterruptedException {

    logger.info("PAYMENT SERVICE IMPL ::: Payment Object Received {}", payment);
    Thread.sleep(1000);

    logger.info("PAYMENT SENT TO TOPIC ::: ...");
    kafkaTemplate.send("payment-topic", payment);
  }
}
