package by.part5.e7resilience;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class Task1 {

  public static Publisher<String> fallbackIfEmpty(Flux<String> publisher, String fallback) {
    return publisher.defaultIfEmpty(fallback);
  }
}