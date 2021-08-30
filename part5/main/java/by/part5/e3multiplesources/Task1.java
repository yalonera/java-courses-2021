package by.part5.e3multiplesources;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class Task1 {

  public static Publisher<String> mergeSeveralSources(Publisher<String>... sources) {
    return Flux.merge(sources);
  }
}