package com.example.regular.payments.mapper;

import com.example.regular.payments.dto.CreatePaymentRequestDto;
import com.example.regular.payments.dto.RegularPaymentDto;
import com.example.regular.payments.model.RegularPayment;
import org.springframework.stereotype.Component;

@Component
public class RegularPaymentMapperImpl implements RegularPaymentMapper {
    @Override
    public RegularPaymentDto toDto(RegularPayment regularPayment) {
        RegularPaymentDto regularPaymentDto = new RegularPaymentDto();

        regularPaymentDto.setId(regularPayment.getId());
        regularPaymentDto.setName(regularPayment.getName());
        regularPaymentDto.setSurname(regularPayment.getSurname());
        regularPaymentDto.setINN(regularPayment.getINN());
        regularPaymentDto.setCardNumber(regularPayment.getCardNumber());
        regularPaymentDto.setRecipientAccount(regularPayment.getRecipientAccount());
        regularPaymentDto.setRecipientMFO(regularPayment.getRecipientMFO());
        regularPaymentDto.setRecipientOKPO(regularPayment.getRecipientOKPO());
        regularPaymentDto.setRecipientName(regularPayment.getRecipientName());
        regularPaymentDto.setPaymentPeriod(regularPayment.getPaymentPeriod());
        regularPaymentDto.setPaymentAmount(regularPayment.getPaymentAmount());

        return regularPaymentDto;
    }

    @Override
    public RegularPayment toModel(CreatePaymentRequestDto requestDto) {
        RegularPayment regularPayment = new RegularPayment();

        regularPayment.setName( requestDto.getName() );
        regularPayment.setSurname( requestDto.getSurname() );
        regularPayment.setINN( requestDto.getINN() );
        regularPayment.setCardNumber( requestDto.getCardNumber() );
        regularPayment.setRecipientAccount( requestDto.getRecipientAccount() );
        regularPayment.setRecipientMFO( requestDto.getRecipientMFO() );
        regularPayment.setRecipientOKPO( requestDto.getRecipientOKPO() );
        regularPayment.setRecipientName( requestDto.getRecipientName() );
        regularPayment.setPaymentPeriod( requestDto.getPaymentPeriod() );
        regularPayment.setPaymentAmount( requestDto.getPaymentAmount() );

        return regularPayment;
    }
}
