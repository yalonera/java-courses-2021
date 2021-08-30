package by.part6;

import java.util.Objects;
import java.util.function.Predicate;

public class Example6 {

  public static void main(String[] args) {
    Predicate<String> predicate = (s) -> s.length() > 0;
    Predicate<String> predicate2 = new Predicate<String>() {
      @Override
      public boolean test(String s) {
        return s.length() > 0;
      }
    };

    System.out.println(predicate.test("foo"));              // true
    System.out.println(predicate.negate().test("foo"));     // false

    Predicate<Boolean> nonNull = Objects::nonNull;
    Predicate<Boolean> isNull = Objects::isNull;

    Predicate<String> isEmpty = String::isEmpty;
    Predicate<String> isNotEmpty = isEmpty.negate();
  }
}
