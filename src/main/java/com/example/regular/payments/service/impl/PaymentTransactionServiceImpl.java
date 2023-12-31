package com.example.regular.payments.service.impl;

import com.example.regular.payments.dto.TransactionResponseDto;
import com.example.regular.payments.exception.EntityNotFoundException;
import com.example.regular.payments.mapper.TransactionMapper;
import com.example.regular.payments.model.PaymentTransaction;
import com.example.regular.payments.model.RegularPayment;
import com.example.regular.payments.repository.PaymentTransactionRepository;
import com.example.regular.payments.service.PaymentTransactionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PaymentTransactionServiceImpl implements PaymentTransactionService {
    private final PaymentTransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public List<TransactionResponseDto> findTransactionsDtoByPaymentId(Long id, Pageable pageable) {
        List<PaymentTransaction> transactions = transactionRepository.findAllByRegularPaymentId(id, pageable);
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
    @Transactional
    public void createReversedTransaction(Long transactionId) {
        PaymentTransaction paymentTransaction = transactionRepository.findByID(transactionId)
                .orElseThrow(() -> new EntityNotFoundException("Can't find transaction by id " + transactionId));
        paymentTransaction.setId(null);
        paymentTransaction.setStatus(PaymentTransaction.PaymentStatus.REVERSED);
        transactionRepository.save(paymentTransaction);
    }

    @Override
    public List<PaymentTransaction> findTransactionsByPaymentId(Long id) {
        return transactionRepository.findAllByRegularPaymentId(id, Pageable.unpaged());
    }
}
