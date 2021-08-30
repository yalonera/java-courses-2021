package by.part6;

import java.util.Optional;

public class Example8 {

  public static Optional<Integer> method() {
    return Optional.empty();
  }

  public static void main(String[] args) {
    Integer a = null;
    if (a != null) {
      System.out.println("a != null");
    } else {
      System.out.println("fallback");
    }

    Optional<String> optional = Optional.of("bam");

    optional.isPresent();           // true
    optional.get();                 // "bam"
    optional.orElse("fallback");    // "bam"

    optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    optional.orElseThrow(() -> new IllegalArgumentException());     // "b"
  }
}
