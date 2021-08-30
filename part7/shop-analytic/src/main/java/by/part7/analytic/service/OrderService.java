package by.part7.analytic.service;

import by.part7.analytic.dto.OrdersDto;
import feign.Headers;
import feign.RequestLine;
import reactor.core.publisher.Flux;

public interface OrderService {

    @RequestLine("GET /order/")
    @Headers("Content-Type: application/json")
    Flux<OrdersDto> findOrders();
}
