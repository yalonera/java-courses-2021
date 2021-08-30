package by.part5.e4multithreading;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Task1 {

  public static Publisher<String> publishOnParallelThreadScheduler(Flux<String> source) {
    System.out.println("publishOnParallelThreadScheduler: " + Thread.currentThread());
    return source
        .publishOn(Schedulers.newParallel("Task1"))
        .doOnNext(x -> System.out.println("doOnNext: " + Thread.currentThread()));
  }
}