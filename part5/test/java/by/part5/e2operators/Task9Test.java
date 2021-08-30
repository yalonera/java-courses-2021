package by.part5.e2operators;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class Task9Test {

  @Test
  public void testSolution() {
    AtomicBoolean subscribed = new AtomicBoolean();
    Mono<Void> sequence =
        Task9.waitUntilFluxCompletion(Flux.interval(Duration.ofMillis(5))
            .doOnSubscribe(__ -> {
              if (!subscribed.compareAndSet(false,
                  true)) {
                throw new RuntimeException("doubleSubscription");
              }
            })
            .take(100));

    StepVerifier.create(sequence)
        .expectComplete()
        .verify(Duration.ofMillis(10000));

    Assertions.assertThat(subscribed.get()).isTrue();
  }
}