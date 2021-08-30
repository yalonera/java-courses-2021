package by.part5.e1publishers;

import reactor.core.publisher.Flux;

public class Task1 {

  public static Flux<Integer> createSequence() {
    return Flux.range(0, 20);
  }
}