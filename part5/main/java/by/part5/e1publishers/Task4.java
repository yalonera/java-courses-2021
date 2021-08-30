package by.part5.e1publishers;

import java.util.stream.Stream;
import reactor.core.publisher.Flux;

public class Task4 {

  public static Flux<String> createSequence(Stream<String> stream) {
    return Flux.fromStream(stream);
  }
}