package com.example.regular.payments.jar;

import com.example.regular.payments.model.PaymentTransaction;
import com.example.regular.payments.model.RegularPayment;
import com.example.regular.payments.service.PaymentTransactionService;
import com.example.regular.payments.service.RegularPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PaymentProcessor {
    private final RegularPaymentService paymentService;
    private final PaymentTransactionService transactionService;

    @Scheduled(fixedRate = 30000)
    public void startPaymentProcessing() {
        List<RegularPayment> payments = paymentService.findAll();
        LocalDateTime currentDateTime = LocalDateTime.now();
        for (RegularPayment payment : payments) {
            List<PaymentTransaction> transactions = transactionService.findTransactionsByPaymentId(payment.getId());

            LocalDateTime lastTransactionDate = findLastTransactionDate(transactions);

            int paymentPeriod = payment.getPaymentPeriod();

            LocalDateTime nextPaymentDateTime = lastTransactionDate.plusSeconds(paymentPeriod);

            if (currentDateTime.isAfter(nextPaymentDateTime)) {
                transactionService.createPaymentTransaction(payment);
            }
        }
    }

    private LocalDateTime findLastTransactionDate(List<PaymentTransaction> transactions) {
        return transactions.stream()
                .map(PaymentTransaction::getTransactionDateTime)
                .max(LocalDateTime::compareTo)
                .orElse(LocalDateTime.now().minusDays(30));
    }
}
