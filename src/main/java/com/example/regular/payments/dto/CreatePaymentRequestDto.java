package com.example.regular.payments.dto;

import com.example.regular.payments.validation.CardNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreatePaymentRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    @Size(min = 10, max = 12, message = "INN должен содержать от 10 до 12 цифр")
    private String INN;
    @NotBlank
    @CardNumber
    private String cardNumber;
    @NotBlank
    private String recipientAccount;
    @NotBlank
    private String recipientMFO;
    @NotBlank
    private String recipientOKPO;
    @NotBlank
    private String recipientName;
    @Positive
    private int paymentPeriod;
    @Positive
    private double paymentAmount;
}
