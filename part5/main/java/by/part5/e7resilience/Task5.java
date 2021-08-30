package by.part5.e7resilience;

import java.time.Duration;
import java.util.concurrent.Callable;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Task5 {

  public static Mono<String> timeoutBlockingOperation(Callable<String> longRunningCall,
      Duration duration,
      String fallback) {
    return Mono.fromCallable(longRunningCall)
        .subscribeOn(Schedulers.boundedElastic())
        .timeout(duration, Mono.just(fallback));
  }
}