package com.example.regular.payments.service;

import com.example.regular.payments.dto.TransactionResponseDto;
import com.example.regular.payments.model.PaymentTransaction;
import com.example.regular.payments.model.RegularPayment;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentTransactionService {
    List<TransactionResponseDto> findTransactionsDtoByPaymentId(Long id , Pageable pageable);

    List<PaymentTransaction> findTransactionsByPaymentId(Long id);

    void createPaymentTransaction(RegularPayment regularPayment);

    void createReversedTransaction(Long transactionId);
}
