package com.example.regular.payments.mapper;

import com.example.regular.payments.dto.TransactionDto;
import com.example.regular.payments.model.PaymentTransaction;

public interface TransactionMapper {
    TransactionDto toDto(PaymentTransaction transaction);
}
