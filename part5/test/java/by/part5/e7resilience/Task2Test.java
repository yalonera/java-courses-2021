package by.part5.e7resilience;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Task2Test {

  @Test
  public void testSolution() {
    StepVerifier
        .create(Task2.fallbackOnError(Flux.error(new RuntimeException()), "Hello"))
        .expectSubscription()
        .expectNext("Hello")
        .verifyComplete();
  }

  @Test
  public void testSolution1() {
    StepVerifier
        .create(Task2.fallbackOnError(Flux.just("123"), "Hello"))
        .expectSubscription()
        .expectNext("123")
        .verifyComplete();
  }

  @Test
  public void testSolution2() {
    StepVerifier
        .create(Task2.fallbackOnError(Flux.empty(), "Hello"))
        .expectSubscription()
        .verifyComplete();
  }
}