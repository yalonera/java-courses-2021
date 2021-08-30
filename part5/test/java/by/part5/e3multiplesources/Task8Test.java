package by.part5.e3multiplesources;

import static by.part5.e3multiplesources.Task8.IceCreamType.CHOCOLATE;
import static by.part5.e3multiplesources.Task8.IceCreamType.VANILLA;

import by.part5.e3multiplesources.Task8.IceCreamBall;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Task8Test {

  @Test
  public void testSolution() {
    StepVerifier
        .withVirtualTime(() -> Task8.fillIceCreamWaffleBowl(
            Flux.just(VANILLA, VANILLA, CHOCOLATE, VANILLA, CHOCOLATE, CHOCOLATE)
                .delayElements(Duration.ofSeconds(1)),
            Flux.interval(Duration.ofMillis(500))
                .map(i -> IceCreamBall.ball("A" + i))
                .onBackpressureDrop()
                .publish(1)
                .autoConnect(0),
            Flux.interval(Duration.ofMillis(200))
                .map(i -> IceCreamBall.ball("B" + i))
                .onBackpressureDrop()
                .publish(1)
                .autoConnect(0)
        ).map(Object::toString))
        .expectSubscription()
        .expectNoEvent(Duration.ofSeconds(1))
        .thenAwait(Duration.ofSeconds(1))
        .expectNext("A1", "A2")
        .thenAwait(Duration.ofSeconds(1))
        .expectNext("A3", "A4")
        .thenAwait(Duration.ofSeconds(1))
        .expectNext("B14", "B15", "B16", "B17", "B18")
        .thenAwait(Duration.ofSeconds(1))
        .expectNext("A5", "A7", "A8")
        .thenAwait(Duration.ofSeconds(1))
        .expectNext("B19", "B24", "B25", "B26", "B27", "B28")
        .thenAwait(Duration.ofSeconds(1))
        .expectNext("B29", "B30", "B31", "B32", "B33")
        // Actually the last source is infinitive stream
        // and because of switchMap nature we required to cancel the upstream
        // instead of merely awaiting the completion signal from upstream
        .thenCancel()
        .verify();
  }
}