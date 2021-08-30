package by.part5.e7resilience;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Task1Test {

  @Test
  public void test1() {
    StepVerifier
        .create(Task1.fallbackIfEmpty(Flux.empty(), "Hello"))
        .expectSubscription()
        .expectNext("Hello")
        .verifyComplete();
  }

  @Test
  public void test2() {
    StepVerifier
        .create(Task1.fallbackIfEmpty(Flux.just("abc"), "Hello"))
        .expectSubscription()
        .expectNext("abc")
        .verifyComplete();
  }
}