package by.part5.e6hotsharable;

import org.reactivestreams.Publisher;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;

public class Task3 {

  public static Publisher<String> transformToHotUsingProcessor(Flux<String> coldSource) {
    return coldSource.subscribeWith(DirectProcessor.create());
  }
}