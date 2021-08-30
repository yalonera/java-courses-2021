package by.part7.analytic.service;

import by.part7.analytic.dto.OrdersDto;
import by.part7.analytic.model.CardsType;
import reactor.core.publisher.Flux;

public class DefaultAnalyticService implements AnalyticService {

    private final OrderService orderService;

    public DefaultAnalyticService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Flux<OrdersDto> ordersForCardType(CardsType cardType) {
        return orderService.findOrders()
                .filter(x -> x.getPaymentInfo().getCardType().equals(cardType));
    }
}