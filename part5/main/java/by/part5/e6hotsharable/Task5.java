package by.part5.e6hotsharable;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.EmitFailureHandler;
import reactor.core.publisher.Sinks.Many;

public class Task5 {

  public static void main(String[] args) {
    directProcessor();
    emitterProcessor();
    replayProcessor();
  }

  private static void replayProcessor() {
    Many<Long> data = Sinks.many().replay().limit(3); // ReplayProcessor
    final Flux<Long> flux = data.asFlux();
    flux.subscribe(t -> System.out.println("subscribe1: " + t));
    data.emitNext(10L, EmitFailureHandler.FAIL_FAST);
    data.emitNext(11L, EmitFailureHandler.FAIL_FAST);
    data.emitNext(12L, EmitFailureHandler.FAIL_FAST);
    data.emitNext(13L, EmitFailureHandler.FAIL_FAST);
    data.emitNext(14L, EmitFailureHandler.FAIL_FAST);
    flux.subscribe(t -> System.out.println("subscribe2: " + t));
  }

  private static void emitterProcessor() {
    Many<Long> data = Sinks.many().multicast().onBackpressureBuffer(1);
    final Flux<Long> flux = data.asFlux();
    flux.subscribe(t -> System.out.println("subscribe1: " + t));
    data.emitNext(10L, EmitFailureHandler.FAIL_FAST);
    data.emitNext(11L, EmitFailureHandler.FAIL_FAST);
    data.emitNext(12L, EmitFailureHandler.FAIL_FAST);
    flux.subscribe(t -> System.out.println("subscribe2: " + t));
    data.emitNext(13L, EmitFailureHandler.FAIL_FAST);
    data.emitNext(14L, EmitFailureHandler.FAIL_FAST);
    data.emitNext(15L, EmitFailureHandler.FAIL_FAST);
  }

  private static void directProcessor() {
    Many<Long> data = Sinks.many().multicast().directBestEffort();
    final Flux<Long> flux = data.asFlux();
    flux.subscribe(
        t -> System.out.println("subscribe1: " + t),
        Throwable::printStackTrace,
        () -> System.out.println("Finished 1")
    );
    data.tryEmitNext(10L);
    data.tryEmitComplete();
    flux.subscribe(
        t -> System.out.println("subscribe2: " + t),
        Throwable::printStackTrace,
        () -> System.out.println("Finished 2")
    );
    data.tryEmitNext(12L);
  }
}