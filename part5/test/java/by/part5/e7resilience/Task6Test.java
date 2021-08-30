package by.part5.e7resilience;

import java.util.function.BiConsumer;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Task6Test {

  @Test
  public void testSolution() {
    BiConsumer<Throwable, Object> consumer = (t, element) -> {
      System.err.println("Thrown an error [" + t.toString() + "] on the following element [" + element + "]");
    };
    Flux<Integer> range = Flux.range(0, 6)
        .map(i -> 10 / i);

    StepVerifier.create(Task6.provideSupportOfContinuation(range, consumer))
        .expectSubscription()
        .expectNextCount(5)
        .expectAccessibleContext()
        .hasKey("reactor.onNextError.localStrategy")
        .then()
        .expectComplete()
        .verify();
  }
}