package com.example.regular.payments.service;

import com.example.regular.payments.dto.TransactionDto;
import com.example.regular.payments.model.PaymentTransaction;
import com.example.regular.payments.model.RegularPayment;
import java.util.List;

public interface PaymentTransactionService {
    List<TransactionDto> findTransactionsDtoByPaymentId(Long id);

    List<PaymentTransaction> findTransactionsByPaymentId(Long id);

    void createPaymentTransaction(RegularPayment regularPayment);

    void createReversedTransaction(Long transactionId);
}
