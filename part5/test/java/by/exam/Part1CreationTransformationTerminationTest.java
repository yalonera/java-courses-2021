package by.exam;

import static by.exam.Part1CreationTransformationTermination.convertNullableValueToPublisher;
import static by.exam.Part1CreationTransformationTermination.deferCalculation;
import static by.exam.Part1CreationTransformationTermination.error;
import static by.exam.Part1CreationTransformationTermination.findAllWordsWithPrefixABC;
import static by.exam.Part1CreationTransformationTermination.flatMapWordsToCharacters;
import static by.exam.Part1CreationTransformationTermination.fromArray;
import static by.exam.Part1CreationTransformationTermination.fromFuture;
import static by.exam.Part1CreationTransformationTermination.interval;
import static by.exam.Part1CreationTransformationTermination.justABC;
import static by.exam.Part1CreationTransformationTermination.mapToString;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Part1CreationTransformationTerminationTest {

  @Test
  public void justABCTest() {
    StepVerifier.create(justABC())
        .expectSubscription()
        .expectNext("ABC")
        .expectComplete()
        .verify();
  }

  @Test
  public void fromArrayOfABCTest() {
    StepVerifier.create(fromArray("A", "B", "C"))
        .expectSubscription()
        .expectNext("A", "B", "C")
        .expectComplete()
        .verify();
  }

  @Test
  public void errorPublisherTest() {
    NullPointerException testException = new NullPointerException("test");

    StepVerifier.create(error(testException))
        .expectSubscription()
        .expectErrorMessage("test")
        .verify();
  }

  @Test
  public void emptyPublisherTest() {
    StepVerifier.create(convertNullableValueToPublisher(1))
        .expectSubscription()
        .expectNext(1)
        .expectComplete()
        .verify();

    StepVerifier.create(convertNullableValueToPublisher(null))
        .expectSubscription()
        .expectNextCount(0)
        .expectComplete()
        .verify();
  }

  @Test
  @SuppressWarnings("unchecked")
  public void deferCalculationPublisherTest() {
    Supplier<Flux<String>> factory = () -> Flux.just("Hello", "World");

    Publisher<String> deferCalculation = deferCalculation(factory);

    StepVerifier.create(deferCalculation)
        .expectSubscription()
        .expectNext("Hello")
        .expectNext("World")
        .expectComplete()
        .verify();
  }

  @Test
  public void intervalTest() {
    StepVerifier
        .withVirtualTime(() -> Flux.from(interval(1, ChronoUnit.SECONDS)).take(2))
        .expectSubscription()
        .expectNoEvent(Duration.ofSeconds(1))
        .expectNext(0L)
        .thenAwait(Duration.ofSeconds(1))
        .expectNext(1L)
        .verifyComplete();
  }

  @Test
  public void mapToStringTest() {
    StepVerifier.create(mapToString(Flux.just(1L, 2L, 3L, 4L)))
        .expectSubscription()
        .expectNext("1", "2", "3", "4")
        .expectComplete()
        .verify();
  }

  @Test
  public void filterTest() {
    StepVerifier.create(findAllWordsWithPrefixABC(Flux.just("asdas", "gdfgsdfg", "ABCasda")))
        .expectSubscription()
        .expectNext("ABCasda")
        .expectComplete()
        .verify();
  }

  @Test
  public void fromFutureTest() {
    StepVerifier.withVirtualTime(() -> fromFuture(CompletableFuture.completedFuture("test")))
        .expectSubscription()
        .expectNext("test")
        .expectComplete()
        .verify();
  }

  @Test
  public void flatMapWordsToCharactersTest() {
    StepVerifier.create(flatMapWordsToCharacters(Flux.just("ABC", "DEFG", "HJKL")))
        .expectSubscription()
        .expectNext('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L')
        .expectComplete()
        .verify();
  }
}
