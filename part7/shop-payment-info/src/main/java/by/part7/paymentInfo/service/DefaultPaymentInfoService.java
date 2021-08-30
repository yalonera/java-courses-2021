package by.part7.paymentInfo.service;

import by.part7.paymentInfo.model.PaymentInfo;
import by.part7.paymentInfo.repository.PaymentInfoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class DefaultPaymentInfoService implements PaymentInfoService {

    private final PaymentInfoRepository repository;

    public DefaultPaymentInfoService(PaymentInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<PaymentInfo> findPaymentInfos() {
        return Flux.fromIterable(repository.findAll());
    }

    @Override
    public Mono<PaymentInfo> findPaymentInfoById(int id) {
        return Mono.fromCallable(() -> repository.findById(id));
    }
}
