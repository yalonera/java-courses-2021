package by.part7.order.service;

import by.part7.order.dto.OrderItemDto;
import by.part7.order.dto.OrdersDto;
import by.part7.order.dto.PaymentInfoDto;
import by.part7.order.model.Order;
import by.part7.order.model.OrderItem;
import by.part7.order.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class DefaultOrderService implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultOrderService.class);

    private final OrderRepository repository;

    private final CustomerService customerService;
    private final ProductService productService;
    private final PaymentInfoService paymentInfoService;

    public DefaultOrderService(
            OrderRepository repository, CustomerService customerService, ProductService productService, PaymentInfoService paymentInfoService) {
        this.repository = repository;
        this.customerService = customerService;
        this.productService = productService;
        this.paymentInfoService = paymentInfoService;
    }

    @Override
    public Flux<Order> findOrders() {
        return Flux.fromIterable(repository.findAll());
    }

    @Override
    public Flux<OrdersDto> findOrdersDto() {
        return Flux.fromIterable(repository.findAll())
                .flatMap(x -> Mono.zip(
                        customerService.findCustomer(x.getCustomerId()),
                        paymentInfoService.findPaymentInfo(x.getPaymentInfoId()),
                        getOrderItems(x.getOrderItems()).collectList())
                        .map(tuple -> {
                            final OrdersDto result = new OrdersDto();
                            result.setId(x.getId());
                            result.setCustomer(tuple.getT1());
                            result.setOrderItems(tuple.getT3());
                            result.setPaymentInfo(tuple.getT2());
                            return result;
                        })
                )
                .doOnError(e -> LOGGER.error("Cannot fetch orders", e));
    }

/*
    private PaymentInfoDto getPaymentInfo(PaymentInfo paymentInfo) {
        final PaymentInfoDto result = new PaymentInfoDto();
        result.setId(paymentInfo.getId());
        result.setCardType(paymentInfo.getCardType());
        result.setCardNumber(paymentInfo.getCardNumber());
        result.setCardType(paymentInfo.getCardType());
        return result;
    }

 */


    private Flux<OrderItemDto> getOrderItems(List<OrderItem> items) {
        return Flux.fromIterable(items)
                .flatMap(o -> productService.findProduct(o.getProductId())
                        .map(p -> {
                            final OrderItemDto item = new OrderItemDto();
                            item.setProduct(p);
                            item.setQuantity(o.getQuantity());
                            item.setId(o.getId());
                            return item;
                        })
                );
    }

    private Flux<PaymentInfoDto> getPaymentInfo(List<PaymentInfoDto> paymentsInfo) {
        return Flux.fromIterable(paymentsInfo)
                .flatMap(o -> paymentInfoService.findPaymentInfo(o.getId())
                        .map(p -> {
                            final PaymentInfoDto pi = new PaymentInfoDto();
                            pi.setId(o.getId());
                            pi.setCardNumber(o.getCardNumber());
                            pi.setCardType(o.getCardType());
                            return pi;
                        }));
    }
}
