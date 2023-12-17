package com.example.regular.payments.dto;

import lombok.Data;

@Data
public class RecipientRequestDto {
    private String recipientAccount;
    private String recipientName;
}
