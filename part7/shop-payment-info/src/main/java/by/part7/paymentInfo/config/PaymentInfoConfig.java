package by.part7.paymentInfo.config;

import by.part7.paymentInfo.controller.PaymentInfoController;
import by.part7.paymentInfo.repository.PaymentInfoRepository;
import by.part7.paymentInfo.repository.JpaPaymentInfoRepository;
import by.part7.paymentInfo.service.PaymentInfoService;
import by.part7.paymentInfo.service.DefaultPaymentInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentInfoConfig {

  @Bean
  public PaymentInfoRepository paymentRepository() {
    return new JpaPaymentInfoRepository();
  }

  @Bean
  public PaymentInfoService paymentService() {
    return new DefaultPaymentInfoService(paymentRepository());
  }

  @Bean
  public PaymentInfoController paymentInfoController() {
    return new PaymentInfoController(paymentService());
  }
}
