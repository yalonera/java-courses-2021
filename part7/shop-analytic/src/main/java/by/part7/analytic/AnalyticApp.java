package by.part7.analytic;

import by.part7.analytic.config.AnalyticConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = AnalyticConfig.class)
public class AnalyticApp {

    public static void main(String[] args) {
        SpringApplication.run(AnalyticApp.class, args);
    }
}