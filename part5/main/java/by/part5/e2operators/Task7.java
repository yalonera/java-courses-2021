package by.part5.e2operators;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Task7 {

  public static Mono<Long> firstFromFlux(Flux<Long> flux) {
    return flux.next();
  }
}