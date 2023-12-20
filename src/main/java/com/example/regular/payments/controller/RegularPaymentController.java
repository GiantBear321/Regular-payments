package com.example.regular.payments.controller;

import com.example.regular.payments.dto.*;
import com.example.regular.payments.service.PaymentTransactionService;
import com.example.regular.payments.service.RegularPaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/payments")
@Tag(name = "Regular Payment management", description = "Endpoints for managing regular payments")
public class RegularPaymentController {
    private final RegularPaymentService paymentService;
    private final PaymentTransactionService transactionService;

    @PostMapping
    @Operation(summary = "Create a new payment", description = "Create a new payment")
    public RegularPaymentResponseDto save(@RequestBody @Valid CreatePaymentRequestDto paymentRequestDto) {
        return paymentService.save(paymentRequestDto);
    }

    @GetMapping("/payers/{id}")
    @Operation(summary = "Find Transactions", description = "Find transactions by payment id")
    public List<TransactionResponseDto> findTransactionsByPayment(@PathVariable Long id, Pageable pageable) {
        return transactionService.findTransactionsDtoByPaymentId(id, pageable);
    }

    @GetMapping("/payers")
    @Operation(summary = "Find Payments", description = "Find payments by payer name and surname")
    public List<RegularPaymentResponseDto> findByPayer(@RequestBody @Valid PayerRequestDto payerRequestDto) {
        return paymentService.findByPayer(payerRequestDto);
    }

    @DeleteMapping("payers/{id}")
    @Operation(summary = "Delete Payment", description = "Delete payment by ID")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        paymentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("payers/{id}")
    @Operation(summary = "Update Payment", description = "Update payment by ID")
    public ResponseEntity<RegularPaymentResponseDto> updateById(@PathVariable Long id,
                                                                @RequestBody @Valid CreatePaymentRequestDto payment) {
        return new ResponseEntity<>(paymentService.updateById(id, payment), HttpStatus.OK);
    }

    @GetMapping("/recipients")
    @Operation(summary = "Find Payments", description = "Find payments by recipient name or account")
    public List<RegularPaymentResponseDto> findByRecipient(@RequestBody RecipientRequestDto recipientRequestDto) {
        return paymentService.findByRecipient(recipientRequestDto);
    }
}
