package by.part5.e5backpressure;

import java.util.function.Function;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Task4 {

  public static Flux<StatisticSnapshot> keepBackpressureForLongRunningOps(Flux<String> queryFlux,
      Function<String, Mono<StatisticSnapshot>> calculateStatistic) {

    return queryFlux
        .onBackpressureLatest()
        .concatMap(calculateStatistic, 1);
  }
}