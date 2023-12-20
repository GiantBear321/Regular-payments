package com.example.regular.payments.dto;

import lombok.Data;

@Data
public class RegularPaymentResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String INN;
    private String cardNumber;
    private String recipientAccount;
    private String recipientMFO;
    private String recipientOKPO;
    private String recipientName;
    private int paymentPeriod;
    private double paymentAmount;
}
