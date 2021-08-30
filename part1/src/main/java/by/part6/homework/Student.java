package by.part6.homework;

public class Student {

  private final String name;
  private final Speciality speciality;
  private final int year;

  public Student(String name, Speciality speciality, int year) {
    this.name = name;
    this.speciality = speciality;
    this.year = year;
  }

  public String getName() {
    return name;
  }

  public Speciality getSpeciality() {
    return speciality;
  }

  public int getYear() {
    return year;
  }
}