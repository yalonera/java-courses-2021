package by.part6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Example9 {

  public static void main(String[] args) {
    List<String> stringCollection = Arrays.asList(
        "ddd2",
        "aaa2",
        "bbb1",
        "aaa1",
        "bbb3",
        "ccc",
        "bbb2",
        "ddd1"
    );

    Stream<String> stream = stringCollection.stream();
    Stream<String> stream1 = Stream.of("ddd2",
        "aaa2",
        "bbb1",
        "aaa1",
        "bbb3",
        "ccc",
        "bbb2",
        "ddd1"
    );
  }
}
