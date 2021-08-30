package by.part5.e1publishers;

import reactor.core.publisher.Flux;

public class Task2 {

  public static Flux<String> createSequenceOfASingleElement(String element) {
    return Flux.just(element);
  }
}