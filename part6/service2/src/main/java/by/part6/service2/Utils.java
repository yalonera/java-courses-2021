package by.part6.service2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufMono;
import reactor.netty.NettyOutbound;
import reactor.netty.http.server.HttpServerResponse;

public class Utils {

  public static <T> NettyOutbound json(HttpServerResponse response, Mono<T> value) {
    final ObjectMapper objectMapper = new ObjectMapper();
    final Mono<ByteBuf> data = value
        .flatMap(x -> {
          try {
            return Mono.just(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(x));
          } catch (JsonProcessingException e) {
            return Mono.error(e);
          }
        })
        .transform(ByteBufMono::fromString);
    return response
        .header("Content-Type", "application/json")
        .send(data);
  }
}
