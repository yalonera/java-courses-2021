package by.part5.e5backpressure;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Task2Test {

  @Test
  public void testSolution() {
    StepVerifier.withVirtualTime(() -> Task2.backpressureByBatching(Flux.interval(
        Duration.ofMillis(1)), Duration.ofMillis(1000)), 0)
        .expectSubscription()
        .thenRequest(1)
        .expectNoEvent(Duration.ofSeconds(1))
        .expectNextCount(1)
        .thenRequest(1)
        .expectNoEvent(Duration.ofSeconds(1))
        .expectNextCount(1)
        .thenCancel()
        .verify();
  }
}