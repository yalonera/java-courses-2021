package by.part6.test.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import by.part6.test.TestUtils;
import by.part6.test.model.Customer;
import by.part6.test.model.Order;
import by.part6.test.model.PaymentInfo;
import by.part6.test.model.Product;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_METHOD)
public class OrderStatsTest {

  private static final List<Customer> customers = TestUtils.generateCustomers();
  private static final List<Order> orders = TestUtils.generateOrders(10);
  private Stream<Customer> customerStream;
  private Stream<Order> orderStream;

  @BeforeEach
  public void setUp() throws Exception {
    customerStream = customers.stream();
    orderStream = orders.stream();
  }

  @Test
  public void task1Test1() {
    final List<Order> visaOrders = OrderStats.ordersForCardType(customerStream, PaymentInfo.CardType.VISA);
    assertEquals(17, visaOrders.size(), "В этом потоке 17 заказов, оплаченных картой VISA.");
    assertEquals(24529, (long) visaOrders.get(4).getOrderId(), "Заказ #24529 оплачен картой VISA.");
  }

  @Test
  public void task1Test2() {
    final List<Order> visaOrders = OrderStats.ordersForCardType(customerStream.limit(3), PaymentInfo.CardType.VISA);
    assertEquals(11, visaOrders.size(), "В этом потоке 11 заказов, оплаченных картой VISA");
    assertEquals(47021, (long) visaOrders.get(9).getOrderId(), "Заказ #47021 оплачен картой VISA");
  }

  @Test
  public void task1Test3() {
    final List<Order> visaOrders = OrderStats.ordersForCardType(Stream.empty(), PaymentInfo.CardType.MASTERCARD);
    assertEquals(0, visaOrders.size(), "В этом потоке нет заказов, оплаченных картой VISA");
  }

  @Test
  public void task2Test1() {
    final Stream<Order> orders = orderStream;
    final Map<Integer, List<Order>> orderSizes = OrderStats.orderSizes(orders);
    assertEquals(3, orderSizes.get(15).size(), "В этом потоке 3 заказа с 15 товарами");
    assertEquals(108233, (long) orderSizes.get(21).get(0).getOrderId(), "В заказе №108233 21 товар");
    assertNull(orderSizes.get(0), "В этом потоке нет заказов с 3 товарами");
  }

  @Test
  public void task2Test2() {
    final Map<Integer, List<Order>> orderSizes = OrderStats.orderSizes(Stream.empty());
    assertEquals(0, orderSizes.size(), "Пустой поток заказа должен приводить к пустому результату");
  }

  @Test
  public void task3Test1() {
    final Stream<Order> orders = orderStream.limit(2);
    final boolean hasColorProduct = OrderStats.hasColorProduct(orders, Product.Color.RED);
    assertTrue(hasColorProduct, "Каждый из заказов в этом потоке содержит красный товар");
  }

  @Test
  public void task3Test2() {
    final Stream<Order> orders = orderStream.limit(4).skip(1);
    final boolean hasColorProduct = OrderStats.hasColorProduct(orders, Product.Color.BLUE);
    assertFalse(hasColorProduct, "Один из заказов в этом потоке не содержит синих товаров");
  }

  @Test
  public void task4Test1() {
    final Map<String, Long> cardsForCustomer = OrderStats.cardsCountForCustomer(customerStream);

    assertEquals(2, (long) cardsForCustomer.get("DonnaDonna@gmail.com"), "Донна использовала 2 кредитные карты");
    assertEquals(2, (long) cardsForCustomer.get("super-rory@tut.by"), "Рори использовал 2 кредитные карты");
    assertEquals(3, (long) cardsForCustomer.get("martha@mail.ru"), "Марта использовала 3 кредитные карты");
    assertEquals(1, (long) cardsForCustomer.get("john.smith@rambler.uk"), "Джон использовал 1 кредитную карту");
    assertEquals(3, (long) cardsForCustomer.get("r0se-tyler@gmail.com"), "Рори использовал 3 кредитные карты");

    final Map<String, Long> emptyMap = OrderStats.cardsCountForCustomer(Stream.empty());
    assertTrue(emptyMap.isEmpty());
  }

  @Test
  public void task5Test1() {
    final Optional<String> mostPopularCountry = OrderStats.mostPopularCountry(customerStream);
    assertEquals(Optional.of("Great Britain"), mostPopularCountry);
  }

  @Test
  public void task5Test2() {
    final Optional<String> mostPopularCountry = OrderStats.mostPopularCountry(customerStream.skip(2));
    assertEquals(Optional.of("USA"), mostPopularCountry);
  }

  @Test
  public void task5Test3() {
    final Optional<String> mostPopularCountry = OrderStats.mostPopularCountry(Stream.empty());
    assertEquals(Optional.empty(), mostPopularCountry);
  }

  @Test
  public void task6Test1() {
    final String testCardNumber = "9785 5409 1111 5555";
    final BigDecimal avgPrice = OrderStats.averageProductPriceForCreditCard(customerStream, testCardNumber);
    assertEquals(495.83, avgPrice.setScale(2, RoundingMode.CEILING).doubleValue(), 0.01);
  }

  @Test
  public void task6Test2() {
    final String testCardNumber = "4111 3456 5454 9900";
    final BigDecimal avgPrice = OrderStats.averageProductPriceForCreditCard(customerStream, testCardNumber);
    assertEquals(524.99, avgPrice.setScale(2, RoundingMode.CEILING).doubleValue(), 0.01);
  }

  @Test
  public void task6Test3() {
    final String testCardNumber = "6677 5432 9587 1670";
    final BigDecimal avgPrice = OrderStats.averageProductPriceForCreditCard(customerStream, testCardNumber);
    assertEquals(505.64, avgPrice.setScale(2, RoundingMode.CEILING).doubleValue(), 0.01);
  }

  @Test
  public void task6Test4() {
    final String testCardNumber = "9785 5409 1111 5555";
    final BigDecimal zeroPrice = OrderStats.averageProductPriceForCreditCard(Stream.empty(), testCardNumber);
    assertEquals(BigDecimal.ZERO, zeroPrice);
  }

  @Test
  public void task6Test5() {
    final BigDecimal nonExistingCard = OrderStats.averageProductPriceForCreditCard(customerStream, "INVALID");
    assertEquals(BigDecimal.ZERO, nonExistingCard);
  }
}