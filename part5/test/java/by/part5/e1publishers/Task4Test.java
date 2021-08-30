package by.part5.e1publishers;

import java.time.Duration;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class Task4Test {

  @Test
  public void testSolution() {
    Flux<String> sequence = Task4.createSequence(Stream.of("1", "2", "3"));

    StepVerifier.create(sequence)
        .expectNext("1", "2", "3")
        .expectComplete()
        .verify(Duration.ofMillis(100));
  }
}