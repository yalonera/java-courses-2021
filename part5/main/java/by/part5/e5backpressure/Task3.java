package by.part5.e5backpressure;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class Task3 {

  public static Flux<String> backpressureByBatching(Flux<Long> upstream, Duration duration) {
    return upstream
        .window(duration)
        .flatMap(f -> f.reduce("", (s, next) -> s + next));
  }
}