package by.part5.e3multiplesources;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Task6Test {

  @Test
  public void testSolution() {
    StepVerifier.withVirtualTime(() -> Flux.from(Task6.zipSeveralSources(
        Flux.interval(Duration.ofMillis(10))
            .map(Object::toString),
        Flux.interval(Duration.ofMillis(5))
            .map(Object::toString),
        Flux.interval(Duration.ofMillis(1))
            .map(Object::toString))
        )
            .take(3)
    )
        .expectSubscription()
        .expectNoEvent(Duration.ofMillis(10))
        .expectNext("000")
        .expectNoEvent(Duration.ofMillis(10))
        .expectNext("111")
        .expectNoEvent(Duration.ofMillis(10))
        .expectNext("222")
        .verifyComplete();
  }
}