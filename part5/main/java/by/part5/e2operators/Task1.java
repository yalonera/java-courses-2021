package by.part5.e2operators;

import java.util.Objects;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class Task1 {

  public static <T> Publisher<String> transformSequence(Publisher<T> publisher) {
    return Flux.from(publisher)
        .map(Objects::toString);
  }
}