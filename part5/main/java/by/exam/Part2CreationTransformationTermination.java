package by.exam;

import java.util.List;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;
import reactor.core.publisher.Mono;

public class Part2CreationTransformationTermination {

  public static Mono<List<String>> collectAllItemsToList(Flux<String> source) {
    // TODO: вернуть List<String>

    throw new RuntimeException("Not implemented");
  }

  public static String lastElementFromSource(Flux<String> source) {
    // TODO: вернуть последний элемент

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> mergeSeveralSources(Publisher<String>... sources) {
    // TODO: объединить входные Publisher

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> fromFirstEmitted(Publisher<String>... sources) {
    // TODO: взять элемент первый элемент из Publisher

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<GroupedFlux<Character, String>> groupWordsByFirstLatter(Flux<String> words) {
    // TODO: сгруппировать по первому символу в слове

    throw new RuntimeException("Not implemented");
  }

  public static Mono<String> executeLazyTerminationOperationAndSendHello(Flux<String> source) {
    // TODO: вернуть "Hello" после окончания обработки source

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> zipSeveralSources(Publisher<String> prefix,
      Publisher<String> word,
      Publisher<String> suffix) {
    // TODO: дождаться значений из Publisher и составить их них общую строку

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> combineSeveralSources(Publisher<String> prefix,
      Publisher<String> word,
      Publisher<String> suffix) {
    // TODO: скомбинировать последние элементы их источника и составить их них общую строку

    throw new RuntimeException("Not implemented");
  }
}
