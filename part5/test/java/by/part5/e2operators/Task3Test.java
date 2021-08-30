package by.part5.e2operators;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class Task3Test {

  @Test
  public void testSolution() {
    Flux<Character> sequence =
        Task3.createSequence(Flux.just("ABC", "dEf", "gfh", "j"));

    StepVerifier.create(sequence)
        .expectNext('A', 'B', 'C', 'd', 'E', 'f', 'g', 'f', 'h', 'j')
        .expectComplete()
        .verify(Duration.ofMillis(100));
  }
}