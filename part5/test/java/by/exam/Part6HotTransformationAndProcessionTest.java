package by.exam;

import static by.exam.Part6HotTransformationAndProcession.processEachSubscriberOnSeparateThread;
import static by.exam.Part6HotTransformationAndProcession.replayLast3ElementsInHotFashion;
import static by.exam.Part6HotTransformationAndProcession.transformToHot;
import static by.exam.Part6HotTransformationAndProcession.transformToHotUsingProcessor;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.ReplayProcessor;
import reactor.core.publisher.UnicastProcessor;
import reactor.test.StepVerifier;

public class Part6HotTransformationAndProcessionTest {

  @Test
  public void transformToHotTest() {
    UnicastProcessor<String> source = UnicastProcessor.create();
    ReplayProcessor<String> consumer1 = ReplayProcessor.create(10);
    ReplayProcessor<String> consumer2 = ReplayProcessor.create(10);

    Publisher<String> publisher = transformToHot(source);

    publisher.subscribe(consumer1);

    source.onNext("A");
    source.onNext("B");
    source.onNext("C");

    publisher.subscribe(consumer2);

    source.onNext("D");
    source.onNext("E");
    source.onNext("F");

    source.onComplete();

    StepVerifier.create(consumer1)
        .expectSubscription()
        .expectNext("A", "B", "C", "D", "E", "F")
        .verifyComplete();

    StepVerifier.create(consumer2)
        .expectSubscription()
        .expectNext("D", "E", "F")
        .verifyComplete();
  }

  @Test
  public void replayLast3ElementsInHotFashionTest() {
    UnicastProcessor<String> source = UnicastProcessor.create();
    ReplayProcessor<String> consumer1 = ReplayProcessor.create(10);
    ReplayProcessor<String> consumer2 = ReplayProcessor.create(10);

    Publisher<String> publisher = replayLast3ElementsInHotFashion(source);

    source.onNext("A");
    source.onNext("B");
    source.onNext("C");

    publisher.subscribe(consumer1);

    source.onNext("D");
    source.onNext("E");
    source.onNext("F");

    publisher.subscribe(consumer2);

    source.onNext("G");

    source.onComplete();

    StepVerifier.create(consumer1)
        .expectSubscription()
        .expectNext("A", "B", "C", "D", "E", "F", "G")
        .verifyComplete();

    StepVerifier.create(consumer2)
        .expectSubscription()
        .expectNext("D", "E", "F", "G")
        .verifyComplete();
  }

  @Test
  public void transformToHotUsingProcessorTest() {
    UnicastProcessor<String> source = UnicastProcessor.create();
    ReplayProcessor<String> consumer1 = ReplayProcessor.create(10);
    ReplayProcessor<String> consumer2 = ReplayProcessor.create(10);

    Publisher<String> publisher = transformToHotUsingProcessor(source);

    publisher.subscribe(consumer1);

    source.onNext("A");
    source.onNext("B");
    source.onNext("C");

    publisher.subscribe(consumer2);

    source.onNext("D");
    source.onNext("E");
    source.onNext("F");

    source.onComplete();

    StepVerifier.create(consumer1)
        .expectSubscription()
        .expectNext("A", "B", "C", "D", "E", "F")
        .verifyComplete();

    StepVerifier.create(consumer2)
        .expectSubscription()
        .expectNext("D", "E", "F")
        .verifyComplete();
  }

  @Test
  public void processEachSubscriberOnSeparateThreadTest() {
    UnicastProcessor<String> source = UnicastProcessor.create();
    ReplayProcessor<String> consumer1 = ReplayProcessor.create(10);
    ReplayProcessor<String> consumer2 = ReplayProcessor.create(10);
    Thread[] forConsumers = new Thread[2];

    Flux<String> publisher = processEachSubscriberOnSeparateThread(source);

    publisher
        .doOnComplete(() -> forConsumers[0] = Thread.currentThread())
        .subscribe(consumer1);

    source.onNext("A");
    source.onNext("B");
    source.onNext("C");

    publisher
        .doOnComplete(() -> forConsumers[1] = Thread.currentThread())
        .subscribe(consumer2);

    source.onNext("D");
    source.onNext("E");
    source.onNext("F");

    source.onComplete();

    StepVerifier.create(consumer1)
        .expectSubscription()
        .expectNext("A", "B", "C", "D", "E", "F")
        .verifyComplete();

    StepVerifier.create(consumer2)
        .expectSubscription()
        .expectNext("D", "E", "F")
        .verifyComplete();

    assertNotEquals(forConsumers[0], forConsumers[1], "Expected execution on different Threads");
  }
}
