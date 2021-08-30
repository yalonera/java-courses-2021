package by.part5.e2operators;

import reactor.core.publisher.Flux;

public class Task10 {

  public static Long transformToImperative(Flux<Long> flux) {
    return flux.blockLast();
  }
}