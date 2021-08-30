package by.part7.analytic.controller;

import by.part7.analytic.model.CardsType;
import by.part7.analytic.dto.OrdersDto;
import by.part7.analytic.service.AnalyticService;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/analytic")
public class AnalyticController {

    private final AnalyticService analyticService;

    public AnalyticController(AnalyticService analyticService) {
        this.analyticService = analyticService;
    }

    @GetMapping(value = "/ordersForCardType/{cardType}")
    @ResponseBody
    public Mono<List<OrdersDto>> ordersForCardType(@PathVariable("cardType") CardsType cardType) {
        return analyticService.ordersForCardType(cardType).collectList();
    }

}
