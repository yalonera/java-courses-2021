package by.part5.e4multithreading;

import java.util.Date;
import reactor.core.publisher.Flux;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;

public class Task3 {

  public static ParallelFlux<Integer> paralellizeWorkOnDifferentThreads(Flux<Integer> source) {
    System.out.println("paralellizeWorkOnDifferentThreads: " + Thread.currentThread());

    return source
        .parallel(16)
        .runOn(Schedulers.parallel())
        .doOnNext(x -> System.out.println("doOnNext: " + new Date() + ", " + Thread.currentThread()));
  }
}