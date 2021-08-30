package by.part5.e3multiplesources;

import static reactor.function.TupleUtils.function;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class Task10 {

  private static class Person { // 4s

    private Long id;
    private String address; //1s
    private String fio;//1s
    private List<String> products;//2s

    public Person(Long id, String address, String fio, List<String> products) {
      this.id = id;
      this.address = address;
      this.fio = fio;
      this.products = products;
    }

    @Override
    public String toString() {
      return "Person{" +
          "id=" + id +
          ", address='" + address + '\'' +
          ", fio='" + fio + '\'' +
          ", products=" + products +
          '}';
    }
  }

  public static void main(String[] args) {
    System.out.println(new Date());
    zipSeveralSources1(Flux.just(1L, 2L, 3L))
        .subscribeOn(Schedulers.immediate())
        .subscribe(x -> System.out.println(new Date() + " " + Thread.currentThread() + " " + x));
  }

  public static Flux<Person> zipSeveralSources1(Flux<Long> ids) {
    return ids.flatMap(id -> {
      final Scheduler parallel = Schedulers.newBoundedElastic(4, 128, "thread");
      return Mono.zip( // 2s
          getAddress(id).subscribeOn(parallel), // 1s
          getFIO(id).defaultIfEmpty("<empty>").subscribeOn(parallel), // 1s
          getProducts(id).defaultIfEmpty(Collections.emptyList()).subscribeOn(parallel) //2s
      )
          .map(function((address, fio, product) -> new Person(id, address, fio, product)));
    });
  }

  private static Mono<String> getAddress(Long x) {
    return Mono.fromCallable(() -> {
      sleep(1000L);
      return x + "address";
    });
  }

  private static void sleep(long l) {
    System.out.println(new Date() + " " + Thread.currentThread() + ", sleep = " + l);
    try {
      Thread.sleep(l);
    } catch (Exception e) {
    }
  }

  private static Mono<String> getFIO(Long x) {
    return Mono.defer(() -> {
      sleep(1000L);
      if (x % 3 == 0) {
        return Mono.empty();
      }
      return Mono.fromCallable(() -> {
        return x + "fio";
      });
    });
  }

  private static Mono<List<String>> getProducts(Long x) {
    return Mono.defer(() -> {
      sleep(2000L);
      if (x % 2 == 0) {
        return Mono.empty();
      }
      return Mono.fromCallable(() -> Collections.singletonList(x + "products"));
    });
  }
}