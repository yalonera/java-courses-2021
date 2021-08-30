package by.part5.e3multiplesources;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Task1Test {

  @Test
  public void mergeSeveralSourcesTest() {
    StepVerifier
        .withVirtualTime(() -> Task1.mergeSeveralSources(
            Flux.just("A").delaySubscription(Duration.ofSeconds(1)),
            Flux.just("B")
        ))
        .expectSubscription()
        .expectNext("B")
        .expectNoEvent(Duration.ofSeconds(1))
        .expectNext("A")
        .verifyComplete();
  }
}