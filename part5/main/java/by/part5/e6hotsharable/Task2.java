package by.part5.e6hotsharable;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.ReplayProcessor;

public class Task2 {

  public static Publisher<String> replayLast3ElementsInHotFashion1(Flux<String> coldSource) {
    return coldSource
        .replay(3)
        .autoConnect();
  }

  public static Publisher<String> replayLast3ElementsInHotFashion2(Flux<String> coldSource) {
    return coldSource.subscribeWith(ReplayProcessor.create(3));
  }
}