package com.example.regular.payments.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "payment_transactions")
public class PaymentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "regularPayment_id")
    private RegularPayment regularPayment;

    @Column(name = "transaction_datetime")
    private LocalDateTime transactionDateTime;

    @Column(name = "payment_amount")
    private double paymentAmount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status = PaymentStatus.ACTIVE;

    public enum PaymentStatus {
        ACTIVE,
        REVERSED
    }
}


