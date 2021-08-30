package by.part5.e1publishers;

import java.util.concurrent.Callable;
import reactor.core.publisher.Mono;

public class Task5 {

  public static Mono<String> createSequence(Callable<String> callable) {
    return Mono.fromCallable(callable);
  }
}