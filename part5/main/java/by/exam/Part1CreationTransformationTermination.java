package by.exam;

import java.time.temporal.TemporalUnit;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.util.annotation.Nullable;

public class Part1CreationTransformationTermination {

  public static Publisher<String> justABC() {
    // TODO: вернуть "ABC"

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> fromArray(String... args) {
    // TODO: вернуть Publisher состоящий из входных аргументов

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> error(Throwable t) {
    // TODO: вернуть Publisher с ошибкой

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<Integer> convertNullableValueToPublisher(@Nullable Integer value) {
    // TODO: вернуть пустой Publisher если value пустой иначе Publisher содержащий value

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> deferCalculation(Supplier<Flux<String>> calculation) {
    // TODO: вернуть отложенный Publisher

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<Long> interval(long interval, TemporalUnit timeUnit) {
    // TODO: вернуть Publisher с интервалом

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> mapToString(Publisher<Long> input) {
    // TODO: сконвертировать Long в String;

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> findAllWordsWithPrefixABC(Publisher<String> input) {
    // TODO: найти все слова начинающиеся с ABC

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> fromFuture(CompletableFuture<String> future) {
    // TODO: вернуть Publisher созданный из future

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<Character> flatMapWordsToCharacters(Publisher<String> input) {
    // TODO: получить Publisher состоящий из символов взятых из слов входного Publisher

    throw new RuntimeException("Not implemented");
  }
}
