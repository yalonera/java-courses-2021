package by.part5.e1publishers;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class Task3Test {

  @Test
  public void testSolution() {
    Flux<String> sequence = Task3.createSequence("1", "2", "3");

    StepVerifier.create(sequence)
        .expectNext("1", "2", "3")
        .expectComplete()
        .verify(Duration.ofMillis(100));
  }
}