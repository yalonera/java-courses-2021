package by.part7.paymentInfo.service;

import by.part7.paymentInfo.model.PaymentInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentInfoService {

    Flux<PaymentInfo> findPaymentInfos();

    Mono<PaymentInfo> findPaymentInfoById(int id);
}
