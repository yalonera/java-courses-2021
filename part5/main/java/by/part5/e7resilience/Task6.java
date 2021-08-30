package by.part5.e7resilience;

import java.util.function.BiConsumer;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class Task6 {

  public static Publisher<Integer> provideSupportOfContinuation(Flux<Integer> values,
      BiConsumer<Throwable, Object> consumer) {
    return values.onErrorContinue(consumer);
  }
}