package by.part5.e3multiplesources;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class Task7 {

  public static Publisher<String> combineSeveralSources(Publisher<String> prefixPublisher,
      Publisher<String> wordPublisher,
      Publisher<String> suffixPublisher) {

    return Flux.combineLatest((args) -> "" + args[0] + args[1] + args[2],
        prefixPublisher,
        wordPublisher,
        suffixPublisher);
  }
}