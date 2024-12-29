package br.dev.ferreiras.kafka.paymentservice.service;

import br.dev.ferreiras.kafka.paymentservice.model.Payment;

public interface PaymentService {

  void sendPayment(Payment payment) throws InterruptedException;
}
