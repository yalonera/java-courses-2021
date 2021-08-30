package by.part7.paymentInfo;

import by.part7.paymentInfo.config.PaymentInfoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = PaymentInfoConfig.class)
public class PaymentInfoApp {

    public static void main(String[] args) {
        SpringApplication.run(PaymentInfoApp.class, args);
    }
}
