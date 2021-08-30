package by.part7.order.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/*
@Table(name = "payment_info")
@Entity
public class PaymentInfo {

  public PaymentInfo() {
  }

  @Id
  @GeneratedValue
  private int id;
  @Enumerated(EnumType.STRING)
  @Column(name = "card_type")
  private CardType cardType;
  @Column(name = "card_number")
  private String cardNumber;
  @Column(name = "security_code")
  private String securityCode;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public CardType getCardType() {
    return cardType;
  }

  public void setCardType(CardType cardType) {
    this.cardType = cardType;
  }

  public String getSecurityCode() {
    return securityCode;
  }

  public void setSecurityCode(String securityCode) {
    this.securityCode = securityCode;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentInfo that = (PaymentInfo) o;
    return cardType == that.cardType
        && Objects.equals(cardNumber, that.cardNumber)
        && Objects.equals(securityCode, that.securityCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardType, cardNumber, securityCode);
  }
}

 */
