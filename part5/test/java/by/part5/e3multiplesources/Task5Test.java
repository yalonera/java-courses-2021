package by.part5.e3multiplesources;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.function.Tuples;

public class Task5Test {

  @Test
  public void testSolution() {
    StepVerifier
        .create(Flux.from(Task5.groupWordsByFirstLatter(Flux.just(
            "ABCA",
            "BCDBB",
            "CDE",
            "BEF",
            "ADE",
            "CFG")))
        )
        .expectSubscription()
        .expectNext(Tuples.of('A', 3))
        .expectNext(Tuples.of('B', 4))
        .expectNext(Tuples.of('C', 2))
        .verifyComplete();
  }
}