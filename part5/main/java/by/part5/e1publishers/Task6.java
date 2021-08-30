package by.part5.e1publishers;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class Task6 {

  public static Flux<Long> createSequence(Duration duration) {
    return Flux.interval(duration)
        .doOnNext(x -> System.out.println(x));
  }
}