package by.part6;

public class Example4 {

  @FunctionalInterface
  interface Converter<F, T> {

    T convert(F from);
  }

  static class Something {

    private final String name;

    Something(String name) {
      this.name = name;
    }

    String startsWith(String s) {
      return name + String.valueOf(s.charAt(0));
    }
  }

  static class Person {

    String firstName;
    String lastName;

    Person() {
    }

    Person(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public void print() {
      System.out.println(this.firstName + " " + this.lastName);
    }
  }

  @FunctionalInterface
  interface PersonFactory<P extends Person> {

    P create(String firstName, String lastName);
  }

  public static void main(String[] args) {
    //Ссылки на методы интерфейса
    Converter<String, Integer> converter = Integer::valueOf;
    Integer converted = converter.convert("123");
    System.out.println(converted);    // 123

    //Ссылки на методы класса
    Something something = new Something("name");
    Converter<String, String> converter2 = something::startsWith;
    String converted2 = converter2.convert("Java");
    System.out.println(converted2);    // "nameJ"

    //Ссылки на конструктор
    PersonFactory<Person> personFactory = Person::new;
    Person person = personFactory.create("Peter", "Parker");
    person.print();
  }
}
