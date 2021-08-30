package by.part5.e1publishers;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class Task2Test {

  @Test
  public void testSolution() {
    Flux<String> sequence = Task2.createSequenceOfASingleElement("test");

    StepVerifier.create(sequence)
        .expectNext("test")
        .expectComplete()
        .verify(Duration.ofMillis(100));
  }
}