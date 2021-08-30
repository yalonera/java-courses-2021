package by.part6;

import by.part6.Example4.Person;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Example7 {

  public static void main(String[] args) {
//Функции
    Function<String, Integer> toInteger = Integer::valueOf;
    Function<String, Integer> backToString = toInteger
        .andThen(String::valueOf)
        .andThen(toInteger);
    System.out.println(backToString.apply("123"));     // "123"

//Поставщики
    Supplier<Person> personSupplier = Person::new;
    Person person = personSupplier.get();// new Person
    person.print();

//Потребители
    Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
    greeter.accept(new Person("Luke", "Skywalker"));
  }
}
