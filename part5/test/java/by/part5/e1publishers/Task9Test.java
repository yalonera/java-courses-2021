package by.part5.e1publishers;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class Task9Test {

  @Test
  public void testFluxEmpty() {
    Flux<Long> sequence = Task9.createFluxEmittingOnlyOnComplete();

    StepVerifier.create(sequence)
        .expectComplete()
        .verify(Duration.ofSeconds(1));
  }

  @Test
  public void testFluxNever() {
    Flux<Void> sequence = Task9.createFluxWhichNeverEmits();

    StepVerifier.create(sequence)
        .expectSubscription()
        .expectNoEvent(Duration.ofMillis(1000))
        .thenCancel()
        .verify();
  }

  @Test
  public void testMonoEmpty() {
    Mono<Long> sequence = Task9.createMonoEmittingOnlyOnComplete();

    StepVerifier.create(sequence)
        .expectComplete()
        .verify(Duration.ofSeconds(1));
  }

  @Test
  public void testMonoNever() {
    Mono<Void> sequence = Task9.createMonoWhichNeverEmits();

    StepVerifier.create(sequence)
        .expectSubscription()
        .expectNoEvent(Duration.ofMillis(1000))
        .thenCancel()
        .verify();
  }
}