package com.example.regular.payments.dto;

import com.example.regular.payments.model.PaymentTransaction;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TransactionDto {
    private Long id;
    private LocalDateTime transactionDateTime;
    private Long paymentId;
    private double paymentAmount;
    private PaymentTransaction.PaymentStatus status;
}
