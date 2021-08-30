package by.part5.e3multiplesources;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class Task2 {

  public static Publisher<String> mergeSeveralSourcesSequential(Publisher<String>... sources) {
    return Flux.mergeSequential(sources);
  }
}