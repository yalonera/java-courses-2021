package by.part5.e2operators;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Task9 {

  public static Mono<Void> waitUntilFluxCompletion(Flux<Long> flux) {
    return flux.then();
  }
}