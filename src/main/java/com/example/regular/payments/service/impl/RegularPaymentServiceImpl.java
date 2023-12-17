package com.example.regular.payments.service.impl;

import com.example.regular.payments.dto.CreatePaymentRequestDto;
import com.example.regular.payments.dto.PayerRequestDto;
import com.example.regular.payments.dto.RecipientRequestDto;
import com.example.regular.payments.dto.RegularPaymentDto;
import com.example.regular.payments.mapper.RegularPaymentMapper;
import com.example.regular.payments.model.RegularPayment;
import com.example.regular.payments.repository.RegularPaymentRepository;
import com.example.regular.payments.service.PaymentTransactionService;
import com.example.regular.payments.service.RegularPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegularPaymentServiceImpl implements RegularPaymentService {
    private final RegularPaymentRepository paymentRepository;
    private final PaymentTransactionService paymentTransactionService;
    private final RegularPaymentMapper paymentMapper;

    @Override
    public List<RegularPaymentDto> findByPayer(PayerRequestDto payerRequestDto) {
        List<RegularPayment> payments = paymentRepository
                .findRegularPaymentByNameAndSurname(payerRequestDto.getName(), payerRequestDto.getSurname());
        return payments.stream().map(paymentMapper::toDto).toList();
    }

    @Override
    public void deleteById(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public RegularPaymentDto updateById(Long id, CreatePaymentRequestDto paymentRequestDto) {
        RegularPayment paymentModel = paymentMapper.toModel(paymentRequestDto);
        paymentModel.setId(id);
        return paymentMapper.toDto(paymentRepository.save(paymentModel));
    }

    @Override
    public RegularPaymentDto save(CreatePaymentRequestDto paymentRequestDto) {
        RegularPayment savedRegularPayment = paymentRepository
                .save(paymentMapper.toModel(paymentRequestDto));
        paymentTransactionService.createPaymentTransaction(savedRegularPayment);
        return paymentMapper.toDto(savedRegularPayment);
    }

    @Override
    public Optional<RegularPayment> findById(Long id) {
        return paymentRepository.findById(id);
    }
    @Override
    public List<RegularPaymentDto> findByRecipient(RecipientRequestDto recipientRequestDto) {
        if (recipientRequestDto.getRecipientAccount() != null) {
            List<RegularPayment> payments = paymentRepository
                    .findByRecipientAccount(recipientRequestDto.getRecipientAccount());

            return payments.stream().map(paymentMapper::toDto).toList();
        }

        if (recipientRequestDto.getRecipientName() != null) {
            List<RegularPayment> payments = paymentRepository
                    .findByRecipientName(recipientRequestDto.getRecipientName());
            return payments.stream().map(paymentMapper::toDto).toList();
        }

        return Collections.emptyList();
    }

    @Override
    public List<RegularPayment> findAll() {
        return paymentRepository.findAll();
    }
}