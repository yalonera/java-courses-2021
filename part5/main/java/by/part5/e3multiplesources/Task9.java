package by.part5.e3multiplesources;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class Task9 {

  public static Publisher<String> readFile(String filename) {
    return Flux.using(
        () -> Files.lines(Paths.get(filename)),
        Flux::fromStream,
        Stream::close
    );
  }
}