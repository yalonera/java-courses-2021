package by.part5.e2operators;

import reactor.core.publisher.Flux;

public class Task4 {

  public static Flux<String> transformSequence(Flux<String> stringFlux) {
    return stringFlux.takeLast(2);
  }
}