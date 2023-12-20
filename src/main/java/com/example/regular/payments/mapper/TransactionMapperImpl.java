package com.example.regular.payments.mapper;

import com.example.regular.payments.dto.TransactionResponseDto;
import com.example.regular.payments.model.PaymentTransaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public TransactionResponseDto toDto(PaymentTransaction transaction) {
        TransactionResponseDto transactionDto = new TransactionResponseDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setTransactionDateTime(transaction.getTransactionDateTime());
        transactionDto.setPaymentAmount(transaction.getPaymentAmount());
        transactionDto.setStatus(transaction.getStatus());
        transactionDto.setPaymentId(transaction.getRegularPayment().getId());

        return transactionDto;
    }
}
