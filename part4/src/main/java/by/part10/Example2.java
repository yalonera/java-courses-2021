package by.part10;

import static by.part10.internal.example2.PersonType.TEACHER;

import by.part10.internal.example2.Car;
import by.part10.internal.example2.Person;
import by.part10.internal.example2.Person.Builder;

public class Example2 {

  public static void main(String[] args) {
    Car.Builder<Car> car = Car.builder()
        .setColor("red")
        .setWheels(4);
    Car build = car.build();
    System.out.println(build);

    new Person("last name", "first name", null, null, null, null, null, null, false, false, false);

    Person person = new Builder()
        .setType(TEACHER)
        .setFirstName("first name")
        .setLastName("last name")
        .setStreetAddress("street")
        .build();

    System.out.println(person);
  }
}
