package br.dev.ferreiras.kafka.json_consumer.model;

import java.io.Serializable;

public class Payment implements Serializable {

  private final Long id;
  private final Long idUser;
  private final Long idProduct;
  private final String cardNumber;

  public Long getId() {
    return id;
  }

  public Long getIdUser() {
    return idUser;
  }

  public Long getIdProduct() {
    return idProduct;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public Payment(Long id, Long idUser, Long idProduct, String cardNumber) {
    this.id = id;
    this.idUser = idUser;
    this.idProduct = idProduct;
    this.cardNumber = cardNumber;
  }

  @Override
  public String toString() {
    return "Payment{" +
           "id=" + id +
           ", idUser=" + idUser +
           ", idProduct=" + idProduct +
           ", cardNumber='" + cardNumber + '\'' +
           '}';
  }
}
