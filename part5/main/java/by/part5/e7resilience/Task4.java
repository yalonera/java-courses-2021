package by.part5.e7resilience;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

public class Task4 {

  public static Publisher<String> timeoutLongOperation(CompletableFuture<String> longRunningCall,
      Duration duration, String fallback) {
    return Mono.fromFuture(longRunningCall)
        .timeout(duration, Mono.just(fallback));
  }
}