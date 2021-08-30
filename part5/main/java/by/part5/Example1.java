package by.part5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Example1 {

  public static void main(String[] args) {
    Publisher<String> mono1 = Mono.just("foobar");

    Publisher<String> flux1 = Flux.just("foo", "bar", "foobar");

    Publisher<String> flux2 = Flux.fromIterable(Arrays.asList("A", "B", "C"));

    final Flux<String> foobar = Mono.just("foobar")
        .flux();

    final Flux<Integer> range = Flux.range(1, 3);
    final Mono<List<Integer>> listMono = range.collectList();

    Flux.range(1, 3)
        .flatMap(x -> {
          System.out.println("flatMap" + x);
          return Mono.just(x * 2);
        })
        .collect(Collectors.toList())
        .subscribe(System.out::println);

    Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .limitRequest(5)
        .skip(3)
        .subscribe(value -> System.out.println("Value: " + value));

    Flux.fromIterable(Arrays.asList("", null))
        .subscribe(System.out::println);
  }
}
