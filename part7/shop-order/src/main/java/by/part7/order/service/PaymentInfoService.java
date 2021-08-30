package by.part7.order.service;

import by.part7.order.dto.PaymentInfoDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentInfoService {
    @RequestLine("GET /customer")
    @Headers("Content-Type: application/json")
    Flux<PaymentInfoDto> findPaymentInfo();

    @RequestLine("GET /paymentinfo/{id}")
    @Headers("Content-Type: application/json")
    Mono<PaymentInfoDto> findPaymentInfo(@Param("id") int id);
}
