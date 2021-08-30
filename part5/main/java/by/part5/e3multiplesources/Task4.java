package by.part5.e3multiplesources;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class Task4 {

  public static Publisher<String> fromFirstEmitted(Publisher<String>... sources) {
    return Flux.first(sources);
  }
}