package by.part5.e2operators;

import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Task8 {

  public static Mono<List<String>> transformToList(Flux<String> flux) {
    return flux.collectList();
  }
}