package by.part5.e2operators;

import reactor.core.publisher.Flux;

public class Task2 {

  public static Flux<String> transformSequence(Flux<String> flux) {
    return flux.filter(s -> s.length() > 3);
  }
}