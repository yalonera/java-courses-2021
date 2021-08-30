package by.part5.e2operators;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class Task6Test {

  @Test
  public void testSolution() {
    Mono<Long> sequence = Task6.createSequence(Flux.range(0, 5)
        .map(Integer::longValue));

    StepVerifier.create(sequence)
        .expectNext(10L)
        .expectComplete()
        .verify(Duration.ofMillis(100));
  }
}