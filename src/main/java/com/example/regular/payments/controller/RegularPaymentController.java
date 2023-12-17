package com.example.regular.payments.controller;

import com.example.regular.payments.dto.*;
import com.example.regular.payments.model.RegularPayment;
import com.example.regular.payments.service.PaymentTransactionService;
import com.example.regular.payments.service.RegularPaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/payments")
public class RegularPaymentController {
    private final RegularPaymentService paymentService;
    private final PaymentTransactionService transactionService;

    @PostMapping
    public RegularPaymentDto save(@RequestBody @Valid CreatePaymentRequestDto paymentRequestDto) {
        return paymentService.save(paymentRequestDto);
    }

    @DeleteMapping("payer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        paymentService.deleteById(id);
    }

    @PutMapping("payer/{id}")
    public ResponseEntity<RegularPaymentDto> updateById(@PathVariable Long id,
                                                     @RequestBody @Valid CreatePaymentRequestDto payment) {
        Optional<RegularPayment> existingPayment = paymentService.findById(id);
        if (existingPayment.isPresent()) {
            RegularPaymentDto updatedPayment = paymentService.updateById(id, payment);
            return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/payer")
    public List<RegularPaymentDto> findByPayer(@RequestBody @Valid PayerRequestDto payerRequestDto) {
        return paymentService.findByPayer(payerRequestDto);
    }

    @GetMapping("/recipient")
    public List<RegularPaymentDto> findByRecipient(@RequestBody RecipientRequestDto recipientRequestDto) {
        return paymentService.findByRecipient(recipientRequestDto);
    }

    @GetMapping("/payer/{id}")
    public List<TransactionDto> findTransactionsByPayment(@PathVariable Long id) {
        return transactionService.findTransactionsDtoByPaymentId(id);
    }
}
