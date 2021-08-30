package by.exam;

import java.util.List;
import reactor.core.publisher.Flux;

public class Part4Backpressure {

  public static Flux<String> dropElementsOnBackpressure(Flux<String> upstream) {
    // TODO: применить противодавление для опускания элементов на выходе

    throw new RuntimeException("Not implemented");
  }

  public static Flux<List<Long>> backpressureByBatching(Flux<Long> upstream) {
    // TODO: уменьшить скорость эмиссии за счет элементов буферизации в 1 секунду

    throw new RuntimeException("Not implemented");
  }
}
