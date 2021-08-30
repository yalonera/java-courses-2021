package by.part5.e5backpressure;

import reactor.core.publisher.Flux;

public class Task1 {

  public static Flux<RefCounted> dropElementsOnBackpressure(Flux<RefCounted> upstream) {
    return upstream.onBackpressureDrop(RefCounted::release);
  }
}