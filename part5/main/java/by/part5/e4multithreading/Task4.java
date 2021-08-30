package by.part5.e4multithreading;

import java.util.function.Function;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Task4 {

  @SuppressWarnings({"rawtypes", "unchecked"})
  public static Flux<Long> modifyStreamExecution(Flux<Long> flux, Function work1, Function work2) {
    System.out.println("paralellizeWorkOnDifferentThreads: " + Thread.currentThread());

    return flux
        .doOnNext(x -> System.out.println("begin: " + Thread.currentThread() + ", " + x))
        .map(work1)
        .doOnNext(x -> System.out.println("work1: " + Thread.currentThread() + ", " + x))
        .subscribeOn(Schedulers.single())
        .publishOn(Schedulers.parallel())
        .map(work2)
        .doOnNext(x -> System.out.println("work2: " + Thread.currentThread() + ", " + x));
  }
}