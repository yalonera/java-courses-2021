package by.exam;

import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.ParallelFlux;

public class Part3MultithreadingParallelization {

  public static Publisher<String> publishOnParallelThreadScheduler(Flux<String> source) {
    // TODO: публиковать элементы в разных параллельних потоках

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> subscribeOnSingleThreadScheduler(Callable<String> blockingCall) {
    // TODO: execute call on different thread
    // TODO: выполнить выхов в другом потоке

    throw new RuntimeException("Not implemented");
  }

  public static ParallelFlux<String> paralellizeWorkOnDifferentThreads(Flux<String> source) {
    // TODO: переключить source в режим параллельной обработки

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> paralellizeLongRunningWorkOnUnboundedAmountOfThread(
      Flux<Callable<String>> streamOfLongRunningSources) {
    // TODO: выполнить каждый элемент в независимом потоке

    throw new RuntimeException("Not implemented");
  }
}
