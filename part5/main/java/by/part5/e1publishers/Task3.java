package by.part5.e1publishers;

import reactor.core.publisher.Flux;

public class Task3 {

  public static Flux<String> createSequence(String... args) {
    return Flux.fromArray(args);
  }
}