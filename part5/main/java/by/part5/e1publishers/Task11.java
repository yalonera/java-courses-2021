package by.part5.e1publishers;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;
import reactor.core.publisher.Flux;

public class Task11 {

  public static void main(String[] args) {
    final Random random = new Random();

    variance01(random)
//    variance02(random)
        .map(x -> x.getKey() + x.getValue())
        .doOnNext(x -> System.out.println("doOnNext: " + x))
        .collect(Collectors.summingInt(x -> x))
        .subscribe(System.out::println);
  }

  private static Flux<Entry<Integer, Integer>> variance01(Random random) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < 3; i++) {
      map.putIfAbsent(i, random.nextInt(100));
    }

    return Flux.fromIterable(map.entrySet());
  }

  private static Flux<SimpleEntry<Integer, Integer>> variance02(Random random) {
    return Flux.generate(() -> 0, (i, s) -> {
      if (i > 3) {
        s.complete();
      }
      s.next(new SimpleEntry<>(i, random.nextInt(100)));
      System.out.println("generate: " + i);
      return i + 1;
    });
  }
}