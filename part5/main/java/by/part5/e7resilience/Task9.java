package by.part5.e7resilience;

import java.time.Duration;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Task9 {

  public static Publisher<String> timeoutOnce(Flux<String> flux,
      Duration duration, String fallback) {
    return flux
        .timeout(Mono.delay(duration))
        .onErrorReturn(fallback);
  }
}