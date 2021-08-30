package by.part7.order.config;

import by.part7.order.controller.OrderController;
import by.part7.order.repository.JpaOrderRepository;
import by.part7.order.repository.OrderRepository;
import by.part7.order.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactivefeign.webclient.WebReactiveFeign;

@Configuration
public class OrderConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConfig.class);

    @Value("${service.customer}")
    private String customerServiceUrl;
    @Value("${service.product}")
    private String productServiceUrl;
    @Value("${service.paymentinfo}")
    private String paymentInfoServiceUrl;

    @Bean
    public OrderRepository orderRepository() {
        return new JpaOrderRepository();
    }

    @Bean
    public OrderService orderService() {
        return new DefaultOrderService(orderRepository(), customerService(), productService(),paymentInfoService());
    }

    @Bean
    public CustomerService customerService() {
        LOGGER.info(customerServiceUrl);
        return WebReactiveFeign
                .<CustomerService>builder()
                .target(CustomerService.class, customerServiceUrl);
    }

    @Bean
    public ProductService productService() {
        LOGGER.info(productServiceUrl);
        return WebReactiveFeign
                .<ProductService>builder()
                .target(ProductService.class, productServiceUrl);
    }

    @Bean
    public PaymentInfoService paymentInfoService() {
        LOGGER.info(paymentInfoServiceUrl);
        return WebReactiveFeign
                .<PaymentInfoService>builder()
                .target(PaymentInfoService.class, paymentInfoServiceUrl);
    }

    @Bean
    public OrderController orderController() {
        return new OrderController(orderService());
    }
}
