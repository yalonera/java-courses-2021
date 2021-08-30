package by.part5.e3multiplesources;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Task4Test {

  @Test
  public void testSolution() {
    StepVerifier
        .withVirtualTime(() -> Task4.fromFirstEmitted(
            Flux.just("a").delaySubscription(Duration.ofSeconds(1)),
            Flux.just("b", "c").delaySubscription(Duration.ofMillis(100)),
            Flux.just("D", "Z").delaySubscription(Duration.ofMillis(10)))
        )
        .expectSubscription()
        .expectNoEvent(Duration.ofMillis(10))
        .expectNext("D", "Z")
        .expectComplete()
        .verify(Duration.ofMillis(4000));
  }
}