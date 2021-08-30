package by.part7.analytic.service;

import by.part7.analytic.dto.OrdersDto;
import by.part7.analytic.model.CardsType;
import reactor.core.publisher.Flux;

public interface AnalyticService {

    Flux<OrdersDto> ordersForCardType(CardsType cardType);
}
