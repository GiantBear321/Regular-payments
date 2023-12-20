package com.example.regular.payments.mapper;

import com.example.regular.payments.dto.TransactionResponseDto;
import com.example.regular.payments.model.PaymentTransaction;

public interface TransactionMapper {
    TransactionResponseDto toDto(PaymentTransaction transaction);
}
