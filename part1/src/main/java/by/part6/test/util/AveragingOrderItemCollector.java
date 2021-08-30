package by.part6.test.util;

import by.part6.test.model.OrderItem;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class AveragingOrderItemCollector implements Collector<OrderItem, BigDecimal[], Optional<BigDecimal>> {

  @Override
  public Supplier<BigDecimal[]> supplier() {
    return () -> new BigDecimal[]{BigDecimal.ZERO, BigDecimal.ZERO};
  }

  @Override
  public BiConsumer<BigDecimal[], OrderItem> accumulator() {
    return (acc, b) -> {
      // b.getProduct().getPrice() * b.getQuantity()
      final BigDecimal quantity = BigDecimal.valueOf(b.getQuantity());
      acc[0] = acc[0].add(b.getProduct().getPrice().multiply(quantity)); // деньги
      acc[1] = acc[1].add(quantity); //количество
    };
  }

  @Override
  public BinaryOperator<BigDecimal[]> combiner() {
    return (acc1, acc2) -> new BigDecimal[]{
        acc1[0].add(acc2[0]),
        acc1[1].add(acc2[1])
    };
  }

  @Override
  public Function<BigDecimal[], Optional<BigDecimal>> finisher() {
    return acc -> Optional.of(acc)
        .filter(a -> a[1].intValue() > 0)
        .map(a -> a[0].divide(a[1], BigDecimal.ROUND_HALF_UP));
  }

  @Override
  public Set<Characteristics> characteristics() {
    return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED, Characteristics.CONCURRENT));
  }
}
