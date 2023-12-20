package com.example.regular.payments.mapper;

import com.example.regular.payments.dto.CreatePaymentRequestDto;
import com.example.regular.payments.dto.RegularPaymentResponseDto;
import com.example.regular.payments.model.RegularPayment;

public interface RegularPaymentMapper {
    RegularPaymentResponseDto toDto(RegularPayment regularPayment);

    RegularPayment toModel(CreatePaymentRequestDto requestDto);
}
