package by.part7.order.dto;

import by.part7.order.model.CardType;
import java.util.Objects;

public class PaymentInfoDto {

  private int id;
  private CardType cardType;
  private String cardNumber;
  private String securityCode;
  public PaymentInfoDto() {
  }

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
    PaymentInfoDto that = (PaymentInfoDto) o;
    return cardType == that.cardType
        && Objects.equals(cardNumber, that.cardNumber)
        && Objects.equals(securityCode, that.securityCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardType, cardNumber, securityCode);
  }
}
