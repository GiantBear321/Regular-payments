package com.example.regular.payments.service;

import com.example.regular.payments.dto.CreatePaymentRequestDto;
import com.example.regular.payments.dto.PayerRequestDto;
import com.example.regular.payments.dto.RecipientRequestDto;
import com.example.regular.payments.dto.RegularPaymentDto;
import com.example.regular.payments.model.PaymentTransaction;
import com.example.regular.payments.model.RegularPayment;
import java.util.List;
import java.util.Optional;

public interface RegularPaymentService {
    List<RegularPaymentDto> findByPayer(PayerRequestDto payerRequestDto);

    List<RegularPaymentDto> findByRecipient(RecipientRequestDto recipientRequestDto);

    void deleteById(Long id);

    RegularPaymentDto updateById(Long id, CreatePaymentRequestDto paymentRequestDto);

    RegularPaymentDto save(CreatePaymentRequestDto paymentRequestDto);

    Optional<RegularPayment> findById(Long id);

    List<RegularPayment> findAll();
}