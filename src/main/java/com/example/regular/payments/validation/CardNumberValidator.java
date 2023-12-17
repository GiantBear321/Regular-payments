package com.example.regular.payments.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class CardNumberValidator implements ConstraintValidator<CardNumber, String> {
    private static final String PATTERN_OF_CARD_NUMBER = "^\\d{4}-\\d{4}-\\d{4}-\\d{4}$";

    @Override
    public boolean isValid(String cardNumber, ConstraintValidatorContext constraintValidatorContext) {
        return cardNumber != null && Pattern.compile(PATTERN_OF_CARD_NUMBER).matcher(cardNumber).matches();
    }
}