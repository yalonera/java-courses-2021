package by.part5.e2operators;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class Task4Test {

  @Test
  public void testSolution() {
    Flux<String> sequence = Task4.transformSequence(Flux.just("ABC", "dEf", "gfh", "j"));

    StepVerifier.create(sequence)
        .expectNext("gfh", "j")
        .expectComplete()
        .verify(Duration.ofMillis(100));
  }
}