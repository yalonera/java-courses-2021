package by.part5.e1publishers;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class Task1Test {

  @Test
  public void testCorrectFluxTypeUsed() {
    Flux<Integer> sequence = Task1.createSequence();
    StepVerifier.create(sequence)
        .expectNext(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19)
        .expectComplete()
        .verify(Duration.ofMillis(100));
  }
}