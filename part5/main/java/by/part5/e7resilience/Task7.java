package by.part5.e7resilience;

import java.util.function.Function;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class Task7 {

  public static Publisher<Integer> provideHandmadeContinuation(Flux<Integer> values,
      Function<Integer, Integer> mapping) {

    return values
        .handle((integer, integerSynchronousSink) -> {
          if (integer != 0) {
            integerSynchronousSink.next(mapping.apply(integer));
          }
        });
  }
}