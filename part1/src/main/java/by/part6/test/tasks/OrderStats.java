package by.part6.test.tasks;

import by.part6.test.model.Customer;
import by.part6.test.model.Order;
import by.part6.test.model.OrderItem;
import by.part6.test.model.PaymentInfo;
import by.part6.test.model.Product;
import by.part6.test.util.AveragingBigDecimalCollector;
import by.part6.test.util.AveragingOrderItemCollector;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class OrderStats {

  //верните список заказов, оплаченных с помощью кредитной карты указанного типа (Visa или MasterCard).
  static List<Order> ordersForCardType(final Stream<Customer> customers, PaymentInfo.CardType cardType) {
    return customers
        .flatMap(x -> x.getOrders().stream())
        .filter(x -> x.getPaymentInfo().getCardType() == cardType)
        .collect(Collectors.toList());
  }

  //верните map, где ключ - это количество товаров в заказе, а значение - это список заказов.
  static Map<Integer, List<Order>> orderSizes(final Stream<Order> orders) {
    return orders.collect(Collectors.groupingBy(x -> x
        .getOrderItems()
        .stream()
        .mapToInt(OrderItem::getQuantity)
        .sum()
    ));
  }

  //возвращайте true, только если КАЖДЫЙ заказ содержит хотя бы один продукт указанного цвета и false в противном случае.
  static Boolean hasColorProduct(final Stream<Order> orders, final Product.Color color) {
    return orders.allMatch(x -> x
        .getOrderItems()
        .stream()
        .anyMatch(y -> y.getProduct().getColor() == color)
    );
  }

  //верните map, где ключ - электронная почта клиента, а значение количестов различных картами которыми он пользовался
  static Map<String, Long> cardsCountForCustomer(final Stream<Customer> customers) {
    return customers.collect(Collectors
        .toMap(
            Customer::getEmail,
            x -> x.getOrders()
                .stream()
                .map(Order::getPaymentInfo)
                .distinct()
                .count()
        ));
  }

  //верните необязательный параметр, содержащий название самой популярной страны указанной в addressInfo.
  // Если есть две или более стран с одинаковыми количество клиентов, верните название страны, имеющее наименьшую длину.
  // Если поток клиентов пуст Optional.empty.
  static Optional<String> mostPopularCountry(final Stream<Customer> customers) {
    return customers
        .collect(Collectors.groupingBy(x -> x.getAddress().getCountry(), Collectors.counting()))
        .entrySet()
        .stream()
        .max(Entry.<String, Long>comparingByValue()
            .thenComparingInt(a -> a.getKey().length()))
        .map(Entry::getKey);
  }

  //вернуть среднюю цену продукта для предоставленного номера кредитной карты.
  //  пример
  //  [
  //    Product1(price = 100$, quantity = 2),
  //    Product2(price = 160$, quantity = 1)
  //  ]
  //  средняя цена будет 120$ ((100 * 2 + 160 * 1) / 3)
  static BigDecimal averageProductPriceForCreditCard(final Stream<Customer> customers, final String cardNumber) {
    final AveragingBigDecimalCollector collector = new AveragingBigDecimalCollector();
    return customers
        .flatMap(x -> x.getOrders().stream())
        .filter(x -> Objects.equals(x.getPaymentInfo().getCardNumber(), cardNumber))
        .flatMap(x -> x.getOrderItems().stream())
//        .flatMap(x -> Stream
//            .generate(() -> x.getProduct().getPrice())
//            .limit(x.getQuantity())
//        )
        .collect(new AveragingOrderItemCollector())
        .orElse(BigDecimal.ZERO);
  }
}
