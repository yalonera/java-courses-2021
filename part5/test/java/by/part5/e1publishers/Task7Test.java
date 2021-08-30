package by.part5.e1publishers;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import reactor.test.StepVerifier;

class Task7Test {

  @Test
  public void testSolution() {
    Publisher<String> sequence = Task7.createSequence(CompletableFuture.supplyAsync(() -> "test"));

    StepVerifier.create(sequence)
        .expectNext("test")
        .expectComplete()
        .verify(Duration.ofMillis(100));
  }
}