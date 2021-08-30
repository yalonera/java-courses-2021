package by.part5.e5backpressure;

import java.time.Duration;
import java.util.List;
import reactor.core.publisher.Flux;

public class Task2 {

  public static Flux<List<Long>> backpressureByBatching(Flux<Long> upstream, Duration duration) {
    return upstream.buffer(duration);
  }
}