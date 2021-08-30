package by.exam;

import static by.exam.Part4Backpressure.backpressureByBatching;
import static by.exam.Part4Backpressure.dropElementsOnBackpressure;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Part4BackpressureTest {

  @Test
  public void dropElementsOnBackpressureTest() {
    DirectProcessor<String> processor = DirectProcessor.create();
    StepVerifier
        .create(dropElementsOnBackpressure(processor), 0)
        .expectSubscription()
        .then(() -> processor.onNext(""))
        .then(() -> processor.onNext(""))
        .thenRequest(1)
        .then(() -> processor.onNext("0"))
        .expectNext("0")
        .then(() -> processor.onNext("0"))
        .then(() -> processor.onNext("0"))
        .thenRequest(1)
        .then(() -> processor.onNext("10"))
        .expectNext("10")
        .thenRequest(1)
        .then(() -> processor.onNext("20"))
        .expectNext("20")
        .then(() -> processor.onNext("40"))
        .then(() -> processor.onNext("30"))
        .then(processor::onComplete)
        .expectComplete()
        .verify();
  }

  @Test
  public void backpressureByBatchingTest() {
    StepVerifier
        .withVirtualTime(() -> backpressureByBatching(Flux.interval(Duration.ofMillis(1))), 0)
        .expectSubscription()
        .thenRequest(1)
        .expectNoEvent(Duration.ofSeconds(1))
        .expectNextCount(1)
        .thenRequest(1)
        .expectNoEvent(Duration.ofSeconds(1))
        .expectNextCount(1)
        .thenCancel()
        .verify();
  }
}
