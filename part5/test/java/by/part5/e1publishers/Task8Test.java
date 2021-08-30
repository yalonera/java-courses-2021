package by.part5.e1publishers;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import reactor.test.StepVerifier;

class Task8Test {

  @Test
  public void testSolution1() {
    Publisher<Integer> sequence = Task8.createSequence(10, 0, 20);

    StepVerifier.create(sequence)
        .expectNext(10)
        .expectComplete()
        .verify(Duration.ofMillis(100));
  }

  @Test
  public void testSolution2() {
    Publisher<Integer> sequence = Task8.createSequence(21, 0, 20);

    StepVerifier.create(sequence)
        .expectError()
        .verify(Duration.ofMillis(100));
  }
}