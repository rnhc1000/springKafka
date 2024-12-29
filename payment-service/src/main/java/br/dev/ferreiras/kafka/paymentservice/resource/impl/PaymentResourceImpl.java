package br.dev.ferreiras.kafka.paymentservice.resource.impl;

import br.dev.ferreiras.kafka.paymentservice.model.Payment;
import br.dev.ferreiras.kafka.paymentservice.resource.PaymentResource;
import br.dev.ferreiras.kafka.paymentservice.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value = "/payments")
public class PaymentResourceImpl implements PaymentResource {

  /**
   * @param payment object representing a payment
   * @return payment
   */

  private final PaymentService paymentService;

  private static final Logger logger = LoggerFactory.getLogger(PaymentResourceImpl.class);
  public PaymentResourceImpl(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @Override
  public ResponseEntity<Payment> payment(Payment payment) {

    try {
      paymentService.sendPayment(payment);
    } catch (InterruptedException ex) {
      logger.debug("Exception occurred! {}", ex.getMessage());
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
