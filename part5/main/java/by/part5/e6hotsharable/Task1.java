package by.part5.e6hotsharable;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class Task1 {

  public static Publisher<String> transformToHotWithOperator(Flux<String> coldSource) {
    return coldSource
        .publish()
        .refCount(3);
  }
}