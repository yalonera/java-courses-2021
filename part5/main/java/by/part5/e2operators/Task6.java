package by.part5.e2operators;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Task6 {

  public static Mono<Long> createSequence(Flux<Long> flux) {
    return flux.reduce(Long::sum);
  }
}