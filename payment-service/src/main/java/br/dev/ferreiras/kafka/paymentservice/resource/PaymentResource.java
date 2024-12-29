package br.dev.ferreiras.kafka.paymentservice.resource;

import br.dev.ferreiras.kafka.paymentservice.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentResource {

  @PostMapping
  ResponseEntity<Payment> payment(@RequestBody Payment payment);
}
