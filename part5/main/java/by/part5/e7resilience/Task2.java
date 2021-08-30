package by.part5.e7resilience;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class Task2 {

  public static Publisher<String> fallbackOnError(Flux<String> publisher, String fallback) {
    return publisher.onErrorReturn(fallback);
  }
}