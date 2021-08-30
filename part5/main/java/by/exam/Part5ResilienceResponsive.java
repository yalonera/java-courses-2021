package by.exam;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Part5ResilienceResponsive {

  public static Publisher<String> fallbackHelloOnEmpty(Flux<String> emptyPublisher) {
    // TODO: в случае, если значение не передано, верните «Hello»

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> fallbackHelloOnError(Flux<String> failurePublisher) {
    // TODO: в случае ошибки верните "Hello"

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> retryOnError(Mono<String> failurePublisher) {
    // TODO: повторить операцию, если ошибка

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> timeoutLongOperation(CompletableFuture<String> longRunningCall) {
    // TODO: ограничить общее выполнение операции до одной секунды
    // TODO: в случае тайм-аута верните "Hello"

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> timeoutLongOperation(Callable<String> longRunningCall) {
    // TODO: ограничить общее выполнение операции до одной секунды
    // TODO: в случае тайм-аута верните "Hello"

    throw new RuntimeException("Not implemented");
  }
}
