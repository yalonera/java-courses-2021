package by.part5.e2operators;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class Task2Test {

  @Test
  public void testSolution() {
    Flux<String> sequence =
        Task2.transformSequence(Flux.just("1", "10", "100", "1000", "10000"));

    StepVerifier.create(sequence)
        .expectNext("1000", "10000")
        .expectComplete()
        .verify(Duration.ofMillis(100));
  }
}