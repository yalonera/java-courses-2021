package by.part5.e3multiplesources;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class Task3 {

  public static Publisher<String> concatSeveralSourcesOrdered(Publisher<String>... sources) {
    return Flux.concat(sources);
  }
}