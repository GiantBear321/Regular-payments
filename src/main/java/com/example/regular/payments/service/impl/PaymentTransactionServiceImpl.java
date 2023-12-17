package com.example.regular.payments.service.impl;

import com.example.regular.payments.dto.TransactionDto;
import com.example.regular.payments.mapper.TransactionMapper;
import com.example.regular.payments.model.PaymentTransaction;
import com.example.regular.payments.model.RegularPayment;
import com.example.regular.payments.repository.PaymentTransactionRepository;
import com.example.regular.payments.service.PaymentTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PaymentTransactionServiceImpl implements PaymentTransactionService {
    private final PaymentTransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public List<TransactionDto> findTransactionsDtoByPaymentId(Long id) {
        List<PaymentTransaction> transactions = transactionRepository.findAllByRegularPaymentId(id);
        return transactions.stream().map(transactionMapper::toDto).toList();
    }

    @Override
    public void createPaymentTransaction(RegularPayment regularPayment) {
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setRegularPayment(regularPayment);
        paymentTransaction.setPaymentAmount(regularPayment.getPaymentAmount());
        paymentTransaction.setTransactionDateTime(LocalDateTime.now());
        transactionRepository.save(paymentTransaction);
    }

    @Override
    public void createReversedTransaction(Long transactionId) {
        PaymentTransaction paymentTransaction = transactionRepository.findByID(transactionId)
                .orElseThrow(() -> new RuntimeException("Can't find transaction by id " + transactionId));
        paymentTransaction.setId(null);
        paymentTransaction.setStatus(PaymentTransaction.PaymentStatus.REVERSED);
        transactionRepository.save(paymentTransaction);
    }

    @Override
    public List<PaymentTransaction> findTransactionsByPaymentId(Long id) {
        return transactionRepository.findAllByRegularPaymentId(id);
    }
}
