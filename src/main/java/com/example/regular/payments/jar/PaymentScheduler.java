package com.example.regular.payments.jar;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentScheduler {
    private final PaymentProcessor paymentProcessor;

    @Scheduled(fixedRate = 30000)
    public void processPaymentsRegularly() {
        paymentProcessor.startPaymentProcessing();
    }
}
