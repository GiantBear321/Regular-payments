package com.example.regular.payments.controller;

import com.example.regular.payments.dto.*;
import com.example.regular.payments.service.PaymentTransactionService;
import com.example.regular.payments.service.RegularPaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @DeleteMapping("payers/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        paymentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("payers/{id}")
    public ResponseEntity<RegularPaymentDto> updateById(@PathVariable Long id,
                                                     @RequestBody @Valid CreatePaymentRequestDto payment) {
        return new ResponseEntity<>(paymentService.updateById(id, payment), HttpStatus.OK);
    }

    @GetMapping("/payers")
    public List<RegularPaymentDto> findByPayer(@RequestBody @Valid PayerRequestDto payerRequestDto) {
        return paymentService.findByPayer(payerRequestDto);
    }

    @GetMapping("/recipients")
    public List<RegularPaymentDto> findByRecipient(@RequestBody RecipientRequestDto recipientRequestDto) {
        return paymentService.findByRecipient(recipientRequestDto);
    }

    @GetMapping("/payers/{id}")
    public List<TransactionDto> findTransactionsByPayment(@PathVariable Long id) {
        return transactionService.findTransactionsDtoByPaymentId(id);
    }
}
