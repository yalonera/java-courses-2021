package by.exam;

import static by.exam.Part2CreationTransformationTermination.collectAllItemsToList;
import static by.exam.Part2CreationTransformationTermination.combineSeveralSources;
import static by.exam.Part2CreationTransformationTermination.executeLazyTerminationOperationAndSendHello;
import static by.exam.Part2CreationTransformationTermination.fromFirstEmitted;
import static by.exam.Part2CreationTransformationTermination.groupWordsByFirstLatter;
import static by.exam.Part2CreationTransformationTermination.lastElementFromSource;
import static by.exam.Part2CreationTransformationTermination.mergeSeveralSources;
import static by.exam.Part2CreationTransformationTermination.zipSeveralSources;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.function.Tuples;

public class Part2CreationTransformationTerminationTest {

  @Test
  public void collectToListTest() {
    StepVerifier
        .create(collectAllItemsToList(Flux.just("A", "B", "C")))
        .expectSubscription()
        .expectNext(Arrays.asList("A", "B", "C"))
        .verifyComplete();
  }

  @Test
  public void lastElementFromSourceTest() {
    String element = lastElementFromSource(Flux.just("Hello", "World"));
    assertEquals("World", element, "Expected 'World' but was [" + element + "]");
  }

  @Test
  public void mergeSeveralSourcesTest() {

    StepVerifier
        .withVirtualTime(() -> mergeSeveralSources(
            Flux.just("A").delaySubscription(Duration.ofSeconds(1)),
            Flux.just("B")
        ))
        .expectSubscription()
        .expectNext("B")
        .expectNoEvent(Duration.ofSeconds(1))
        .expectNext("A")
        .verifyComplete();
  }

  @Test
  public void firstEmittedRaceTest() {
    StepVerifier
        .withVirtualTime(() -> fromFirstEmitted(
            Flux.just("a").delaySubscription(Duration.ofSeconds(1)),
            Flux.just("b", "c").delaySubscription(Duration.ofMillis(100)),
            Flux.just("D", "Z").delaySubscription(Duration.ofMillis(10))
        ))
        .expectSubscription()
        .expectNoEvent(Duration.ofMillis(10))
        .expectNext("D", "Z")
        .verifyComplete();
  }

  @Test
  public void groupByWordsByFirstLatterTest() {
    StepVerifier
        .create(
            Flux
                .from(groupWordsByFirstLatter(Flux.just("ABC", "BCD", "CDE", "BEF", "ADE", "CFG")))
                .flatMap(gf -> gf.collectList().map(l -> Tuples.of(gf.key(), l)))
        )
        .expectSubscription()
        .expectNext(Tuples.of('A', Arrays.asList("ABC", "ADE")))
        .expectNext(Tuples.of('B', Arrays.asList("BCD", "BEF")))
        .expectNext(Tuples.of('C', Arrays.asList("CDE", "CFG")))
        .verifyComplete();
  }

  @Test
  public void executeLazyTerminationOperationAndSendHelloTest() {
    StepVerifier
        .withVirtualTime(() -> executeLazyTerminationOperationAndSendHello(
            Flux.just("A").delaySubscription(Duration.ofSeconds(1))
        ))
        .expectSubscription()
        .expectNoEvent(Duration.ofSeconds(1))
        .expectNext("Hello")
        .verifyComplete();
  }

  @Test
  public void zipSourcesTest() {
    StepVerifier
        .withVirtualTime(() -> Flux.from(zipSeveralSources(
            Flux.interval(Duration.ofMillis(10)).map(x -> x + 1).map(Object::toString),
            Flux.interval(Duration.ofMillis(5)).map(x -> x + 2).map(Object::toString),
            Flux.interval(Duration.ofMillis(1)).map(x -> x + 3).map(Object::toString)
        )).take(3))
        .expectSubscription()
        .expectNoEvent(Duration.ofMillis(10))
        .expectNext("123")
        .expectNoEvent(Duration.ofMillis(10))
        .expectNext("234")
        .expectNoEvent(Duration.ofMillis(10))
        .expectNext("345")
        .verifyComplete();
  }

  @Test
  public void combineLatestSourcesTest() {
    StepVerifier
        .withVirtualTime(() -> Flux.from(combineSeveralSources(
            Flux.interval(Duration.ofMillis(10)).map(Object::toString),
            Flux.interval(Duration.ofMillis(5)).map(Object::toString),
            Flux.interval(Duration.ofMillis(1)).map(Object::toString)
        )).take(16))
        .expectSubscription()
        .expectNoEvent(Duration.ofMillis(10))
        .expectNext("008", "018", "019")
        .expectNoEvent(Duration.ofMillis(1))
        .expectNext("0110")
        .thenAwait(Duration.ofMillis(4))
        .expectNext("0111", "0112", "0113", "0213", "0214")
        .thenAwait(Duration.ofMillis(5))
        .expectNext("0215", "0216", "0217", "0218", "1218", "1318", "1319")
        .verifyComplete();
  }
}
