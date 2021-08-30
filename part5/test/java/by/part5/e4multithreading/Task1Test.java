package by.part5.e4multithreading;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Task1Test {

  @Test
  public void mergeSeveralSourcesTest() {
    Thread[] threads = new Thread[2];
    final Flux<String> hello = Flux.from(Task1.publishOnParallelThreadScheduler(Flux
        .defer(() -> {
          threads[0] = Thread.currentThread();
          return Flux.just("Hello");
        })))
        .doFinally(__ -> threads[1] = Thread.currentThread());
    StepVerifier
        .create(hello)
        .expectSubscription()
        .expectNext("Hello")
        .verifyComplete();

    Assertions.assertThat(threads[0])
        .isNotNull()
        .isNotEqualTo(threads[1]);
    Assertions.assertThat(threads[1])
        .isNotNull();
  }
}