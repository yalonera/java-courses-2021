package by.part5.e2operators;

import java.time.Duration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

class Task10Test {

  @Test
  public void testSolution() {
    Long value = Task10.transformToImperative(Flux.interval(Duration.ofMillis(5))
        .take(10));

    Assertions.assertThat(value).isEqualTo(9);
  }
}