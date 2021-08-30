package by.exam;

import static by.exam.Part3MultithreadingParallelization.paralellizeLongRunningWorkOnUnboundedAmountOfThread;
import static by.exam.Part3MultithreadingParallelization.paralellizeWorkOnDifferentThreads;
import static by.exam.Part3MultithreadingParallelization.publishOnParallelThreadScheduler;
import static by.exam.Part3MultithreadingParallelization.subscribeOnSingleThreadScheduler;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.Duration;
import java.util.concurrent.Callable;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Part3MultithreadingParallelizationTest {

  @Test
  public void publishOnParallelThreadSchedulerTest() {
    Thread[] threads = new Thread[2];
    StepVerifier
        .create(publishOnParallelThreadScheduler(Flux.defer(() -> {
          threads[0] = Thread.currentThread();
          return Flux.just("Hello");
        })))
        .expectSubscription()
        .expectNext("Hello")
        .verifyComplete();

    assertNotEquals(threads[0], threads[1], "Expected execution on different Threads");
  }

  @Test
  public void subscribeOnSingleThreadSchedulerTest() {
    Thread[] threads = new Thread[1];
    StepVerifier
        .create(subscribeOnSingleThreadScheduler(() -> {
          System.out.println("Threads:" + Thread.currentThread().getName());
          threads[0] = Thread.currentThread();
          return "Hello";
        }))
        .expectSubscription()
        .expectNext("Hello")
        .verifyComplete();

    assertNotEquals(threads[0], Thread.currentThread(), "Expected execution on different Threads");
  }

  @Test
  public void paralellizeWorkOnDifferentThreadsTest() {
    StepVerifier
        .create(paralellizeWorkOnDifferentThreads(
            Flux.just("Hello", "Hello", "Hello")
        ))
        .expectSubscription()
        .expectNext("Hello", "Hello", "Hello")
        .expectComplete()
        .verify();
  }

  @Test
  public void paralellizeLongRunningWorkOnUnboundedAmountOfThreadTest() {
    Thread[] threads = new Thread[3];
    StepVerifier
        .create(paralellizeLongRunningWorkOnUnboundedAmountOfThread(Flux.<Callable<String>>just(
            () -> {
              threads[0] = Thread.currentThread();
              Thread.sleep(300);
              return "Hello";
            },
            () -> {
              threads[1] = Thread.currentThread();
              Thread.sleep(300);
              return "Hello";
            },
            () -> {
              threads[2] = Thread.currentThread();
              Thread.sleep(300);
              return "Hello";
            }
        ).repeat(20)))
        .expectSubscription()
        .expectNext("Hello", "Hello", "Hello")
        .expectNextCount(60)
        .expectComplete()
        .verify(Duration.ofMillis(600));

    assertNotEquals(threads[0], threads[1], "Expected execution on different Threads");
    assertNotEquals(threads[1], threads[2], "Expected execution on different Threads");
    assertNotEquals(threads[0], threads[2], "Expected execution on different Threads");
  }
}
