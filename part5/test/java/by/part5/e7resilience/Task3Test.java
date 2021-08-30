package by.part5.e7resilience;

import java.util.concurrent.Callable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Task3Test {

  @Test
  public void testSolution() throws Exception {
    Callable<String> callable = Mockito.mock(Callable.class);
    Mockito.when(callable.call())
        .thenThrow(new RuntimeException())
        .thenReturn("Hello");

    StepVerifier
        .create(Task3.retryOnError(Mono.fromCallable(callable)))
        .expectSubscription()
        .expectNext("Hello")
        .expectComplete()
        .verify();
  }
}