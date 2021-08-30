package by.part7.paymentInfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "address_info")
@Entity
public class AddressInfo {

  public AddressInfo() {
  }

  @Id
  @GeneratedValue
  private int id;
  private String country;
  private String city;
  private String street;
  private Integer houseNumber;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Integer getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(Integer houseNumber) {
    this.houseNumber = houseNumber;
  }
}
