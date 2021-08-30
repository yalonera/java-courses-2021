package by.part7.analytic.config;

import by.part7.analytic.controller.AnalyticController;
import by.part7.analytic.service.AnalyticService;
import by.part7.analytic.service.DefaultAnalyticService;
import by.part7.analytic.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactivefeign.webclient.WebReactiveFeign;

@Configuration
public class AnalyticConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnalyticConfig.class);

    @Value("${service.order}")
    private String orderServiceUrl;


    @Bean
    public AnalyticService analyticService() {
        return new DefaultAnalyticService(orderService());
    }

    @Bean
    public OrderService orderService() {
        LOGGER.info(orderServiceUrl);
        return WebReactiveFeign
                .<OrderService>builder()
                .target(OrderService.class, orderServiceUrl);
    }

    @Bean
    public AnalyticController analyticController() {
        return new AnalyticController(analyticService());
    }
}
