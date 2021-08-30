package by.part10.internal.example2;

import java.util.List;

public class Teacher extends Person {

  private final List<String> lessons;

  public Teacher(String newLastName, String newFirstName, String newMiddleName,
      String newSalutation, String newSuffix, String newStreetAddress, String newCity,
      String newState, boolean newIsFemale, boolean newIsEmployed, boolean newIsHomeOwner,
      List<String> lessons) {
    super(newLastName, newFirstName, newMiddleName, newSalutation, newSuffix, newStreetAddress, newCity, newState,
        newIsFemale, newIsEmployed, newIsHomeOwner);
    this.lessons = lessons;
  }
}
