package by.part7.paymentInfo.controller;

import by.part7.paymentInfo.model.PaymentInfo;
import by.part7.paymentInfo.service.PaymentInfoService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/paymentinfo")
public class PaymentInfoController {

  private final PaymentInfoService paymentinfoService;

  public PaymentInfoController(PaymentInfoService paymentinfoService) {
    this.paymentinfoService = paymentinfoService;
  }

  @GetMapping(value = "/")
  @ResponseBody
  public Mono<List<PaymentInfo>> findPaymentInfos() {
    return paymentinfoService.findPaymentInfos().collectList();
  }

  @GetMapping(value = "/{id}")
  @ResponseBody
  public Mono<PaymentInfo> findPaymentInfoById(@PathVariable("id") int id) {
    return paymentinfoService.findPaymentInfoById(id);
  }
}
