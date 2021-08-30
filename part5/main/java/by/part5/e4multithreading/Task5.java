package by.part5.e4multithreading;

import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class Task5 {

  public static Publisher<String> paralellizeLongRunningWorkOnUnboundedAmountOfThread(
      Flux<Callable<String>> streamOfLongRunningSources) {
    System.out.println("paralellizeLongRunningWorkOnUnboundedAmountOfThread: " + Thread.currentThread());

    Scheduler boundedElastic = Schedulers
        .newBoundedElastic(2, 200, "BoundedElastic");
    return streamOfLongRunningSources
        .doOnNext(x -> System.out.println("streamOfLongRunningSources: " + Thread.currentThread() + ", " + x))
        .flatMap(call -> Mono.fromCallable(call).subscribeOn(boundedElastic)
            .doOnNext(x -> System.out.println("fromCallable: " + Thread.currentThread() + ", " + x))
        );
  }
}