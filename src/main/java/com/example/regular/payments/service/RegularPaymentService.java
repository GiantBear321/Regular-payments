package com.example.regular.payments.service;

import com.example.regular.payments.dto.CreatePaymentRequestDto;
import com.example.regular.payments.dto.PayerRequestDto;
import com.example.regular.payments.dto.RecipientRequestDto;
import com.example.regular.payments.dto.RegularPaymentResponseDto;
import com.example.regular.payments.model.RegularPayment;
import java.util.List;

public interface RegularPaymentService {
    List<RegularPaymentResponseDto> findByPayer(PayerRequestDto payerRequestDto);

    List<RegularPaymentResponseDto> findByRecipient(RecipientRequestDto recipientRequestDto);

    void deleteById(Long id);

    RegularPaymentResponseDto updateById(Long id, CreatePaymentRequestDto paymentRequestDto);

    RegularPaymentResponseDto save(CreatePaymentRequestDto paymentRequestDto);

    RegularPayment findById(Long id);

    List<RegularPayment> findAll();
}
