package by.exam;

import static by.exam.Part5ResilienceResponsive.fallbackHelloOnEmpty;
import static by.exam.Part5ResilienceResponsive.fallbackHelloOnError;
import static by.exam.Part5ResilienceResponsive.retryOnError;
import static by.exam.Part5ResilienceResponsive.timeoutLongOperation;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Part5ResilienceResponsiveTest {

  @Test
  public void fallbackHelloOnEmptyTest() {
    StepVerifier
        .create(fallbackHelloOnEmpty(Flux.empty()))
        .expectSubscription()
        .expectNext("Hello")
        .verifyComplete();
  }

  @Test
  public void fallbackHelloOnErrorTest() {
    StepVerifier
        .create(fallbackHelloOnError(Flux.error(new RuntimeException())))
        .expectSubscription()
        .expectNext("Hello")
        .verifyComplete();
  }

  @Test
  public void retryOnErrorTest() throws Exception {
    Callable<String> callable = Mockito.mock(Callable.class);
    Mockito.when(callable.call())
        .thenThrow(new RuntimeException())
        .thenReturn("Hello");

    StepVerifier
        .create(retryOnError(Mono.fromCallable(callable)))
        .expectSubscription()
        .expectNext("Hello")
        .expectComplete()
        .verify();
  }

  @Test
  public void timeoutLongOperationWithCompletableFutureTest() {
    StepVerifier
        .withVirtualTime(() -> timeoutLongOperation(CompletableFuture.supplyAsync(() -> {
          try {
            Thread.sleep(1000000);
          } catch (InterruptedException e) {
            return null;
          }

          return "Toooooo long";
        })))
        .expectSubscription()
        .expectNoEvent(Duration.ofSeconds(1))
        .expectNext("Hello")
        .expectComplete()
        .verify(Duration.ofSeconds(1));
  }

  @Test
  public void timeoutLongOperationWithCallableTest() {
    StepVerifier
        .create(timeoutLongOperation(() -> {
          try {
            Thread.sleep(1000000);
          } catch (InterruptedException e) {
            return null;
          }

          return "Toooooo long";
        }))
        .expectSubscription()
        .expectNext("Hello")
        .expectComplete()
        .verify(Duration.ofSeconds(2));
  }
}
