package by.part5.e1publishers;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class Task5Test {

  @Test
  public void testSolution() {
    Mono<String> sequence = Task5.createSequence(() -> "test");

    StepVerifier.create(sequence)
        .expectNext("test")
        .expectComplete()
        .verify(Duration.ofMillis(100));
  }
}