package by.exam;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class Part6HotTransformationAndProcession {

  public static Publisher<String> transformToHot(Flux<String> coldSource) {
    // TODO: преобразовать в горячий, публикуя элементы независимо от количества подписчиков

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> replayLast3ElementsInHotFashion(Flux<String> coldSource) {
    // TODO: повторить 3 последнийх элемента для подписчиков

    throw new RuntimeException("Not implemented");
  }

  public static Publisher<String> transformToHotUsingProcessor(Flux<String> coldSource) {
    // TODO: использовать процессор для преобразования холодного источника в горячий

    throw new RuntimeException("Not implemented");
  }

  public static Flux<String> processEachSubscriberOnSeparateThread(Flux<String> coldSource) {
    // TODO: использовать процессор для преобразования холодного источника в горячий
    // TODO: обрабатывать каждую подписку в собственном выделенном потоке

    throw new RuntimeException("Not implemented");
  }
}
