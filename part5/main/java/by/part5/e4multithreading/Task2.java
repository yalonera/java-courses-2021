package by.part5.e4multithreading;

import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Task2 {

  public static Publisher<String> subscribeOnSingleThreadScheduler(Callable<String> blockingCall) {
    System.out.println("subscribeOnSingleThreadScheduler: " + Thread.currentThread());
    return Mono.fromCallable(blockingCall)
        .doOnNext(x -> System.out.println("doOnNext: " + Thread.currentThread()))
        .subscribeOn(Schedulers.single());
  }
}