package by.part10.internal.example2;

import java.util.List;

public class Student extends Person {

  private final List<Integer> marks;

  public Student(String newLastName, String newFirstName, String newMiddleName,
      String newSalutation, String newSuffix, String newStreetAddress, String newCity,
      String newState, boolean newIsFemale, boolean newIsEmployed, boolean newIsHomeOwner,
      List<Integer> marks) {
    super(newLastName, newFirstName, newMiddleName, newSalutation, newSuffix, newStreetAddress, newCity, newState,
        newIsFemale, newIsEmployed, newIsHomeOwner);
    this.marks = marks;
  }
}
