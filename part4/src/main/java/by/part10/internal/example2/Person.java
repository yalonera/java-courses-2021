package by.part10.internal.example2;

import java.util.Collections;

public class Person {

  private final String lastName;
  private final String firstName;
  private final String middleName;
  private final String salutation;
  private final String suffix;
  private final String streetAddress;
  private final String city;
  private final String state;
  private final boolean isFemale;
  private final boolean isEmployed;
  private final boolean isHomeOwner;

  public Person(
      final String newLastName,
      final String newFirstName,
      final String newMiddleName,
      final String newSalutation,
      final String newSuffix,
      final String newStreetAddress,
      final String newCity,
      final String newState,
      final boolean newIsFemale,
      final boolean newIsEmployed,
      final boolean newIsHomeOwner) {

    this.lastName = newLastName;
    this.firstName = newFirstName;
    this.middleName = newMiddleName;
    this.salutation = newSalutation;
    this.suffix = newSuffix;
    this.streetAddress = newStreetAddress;
    this.city = newCity;
    this.state = newState;
    this.isFemale = newIsFemale;
    this.isEmployed = newIsEmployed;
    this.isHomeOwner = newIsHomeOwner;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getSalutation() {
    return salutation;
  }

  public String getSuffix() {
    return suffix;
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public boolean isFemale() {
    return isFemale;
  }

  public boolean isEmployed() {
    return isEmployed;
  }

  public boolean isHomeOwner() {
    return isHomeOwner;
  }

  @Override
  public String toString() {
    return "Person{" +
        "lastName='" + lastName + '\'' +
        ", firstName='" + firstName + '\'' +
        ", middleName='" + middleName + '\'' +
        ", salutation='" + salutation + '\'' +
        ", suffix='" + suffix + '\'' +
        ", streetAddress='" + streetAddress + '\'' +
        ", city='" + city + '\'' +
        ", state='" + state + '\'' +
        ", isFemale=" + isFemale +
        ", isEmployed=" + isEmployed +
        ", isHomeOwner=" + isHomeOwner +
        '}';
  }

  public static class Builder {

    private String nestedLastName;
    private String nestedFirstName;
    private String nestedMiddleName;
    private String nestedSalutation;
    private String nestedSuffix;
    private String nestedStreetAddress;
    private String nestedCity;
    private String nestedState;
    private boolean nestedIsFemale;
    private boolean nestedIsEmployed;
    private boolean nestedIsHomeOwner;
    private PersonType type;

    public Builder setLastName(String nestedLastName) {
      this.nestedLastName = nestedLastName;

      return this;
    }

    public Builder setFirstName(String nestedFirstName) {
      this.nestedFirstName = nestedFirstName;

      return this;
    }

    public Builder setMiddleName(String nestedMiddleName) {
      this.nestedMiddleName = nestedMiddleName;

      return this;
    }

    public Builder setSalutation(String nestedSalutation) {
      this.nestedSalutation = nestedSalutation;

      return this;
    }

    public Builder setSuffix(String nestedSuffix) {
      this.nestedSuffix = nestedSuffix;

      return this;
    }

    public Builder setStreetAddress(String nestedStreetAddress) {
      this.nestedStreetAddress = nestedStreetAddress;

      return this;
    }

    public Builder setCity(String nestedCity) {
      this.nestedCity = nestedCity;

      return this;
    }

    public Builder setState(String nestedState) {
      this.nestedState = nestedState;

      return this;
    }

    public Builder setIsFemale(boolean nestedIsFemale) {
      this.nestedIsFemale = nestedIsFemale;

      return this;
    }

    public Builder setIsEmployed(boolean nestedIsEmployed) {
      this.nestedIsEmployed = nestedIsEmployed;

      return this;
    }

    public Builder setIsHomeOwner(boolean nestedIsHomeOwner) {
      this.nestedIsHomeOwner = nestedIsHomeOwner;

      return this;
    }

    public Person build() {
      if (type.equals(PersonType.STUDENT)) {
        return new Student(
            nestedLastName, nestedFirstName, nestedMiddleName,
            nestedSalutation, nestedSuffix,
            nestedStreetAddress, nestedCity, nestedState,
            nestedIsFemale, nestedIsEmployed, nestedIsHomeOwner, Collections.emptyList());
      } else if (type.equals(PersonType.TEACHER)) {
        return new Teacher(
            nestedLastName, nestedFirstName, nestedMiddleName,
            nestedSalutation, nestedSuffix,
            nestedStreetAddress, nestedCity, nestedState,
            nestedIsFemale, nestedIsEmployed, nestedIsHomeOwner, Collections.emptyList());
      }
      throw new IllegalArgumentException("Unknown type: " + type);
    }

    public Builder setType(PersonType type) {
      this.type = type;
      return this;
    }
  }
}