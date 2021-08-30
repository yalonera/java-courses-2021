package by.part10.homework;

import by.part10.homework.model.Order;
import by.part10.homework.model.OrderItem;
import by.part10.homework.model.OrderItemBuilder;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class HomeWork1 {
// Product
// OrderItem
// Order

    // Напишите классы и методы описывающие продажу кофе и чая в кофейне, например старбакс.
    // Храните историю продаж в файле на диске
    // Организуйте удобную систему хранения информации по постоянным клиентам
    // Учтите меняющеся цены на напитки, а так же акции (например каждый пятый бесплатно)
    // Добавьте возможность добавления в систему сдобы или других продуктов для продажи их в будущем.

    // builder для формирования заказа
    // Command для сохранения в файл
    // Strategy для расчета суммы
    public static void main(String[] args) {

        final OrderItemBuilder build = new OrderItemBuilder();
        //

        build.setPrice(BigDecimal.valueOf(99));
        //
        //
        //

        final List<OrderItem> orderItems = Arrays.asList(
                build.tea(),
                new OrderItemBuilder()
                        .setQuantity(2)
                        .setPrice(BigDecimal.valueOf(150))
                        .coffee()
        );

        final Order order = new Order();
        order.setOrderId(1L);
        order.setOrderItems(orderItems);
    }
}
