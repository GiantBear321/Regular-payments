package com.example.regular.payments.repository;

import com.example.regular.payments.model.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long> {
    @Query("SELECT pt FROM PaymentTransaction pt JOIN FETCH pt.regularPayment rp WHERE rp.id = :paymentId")
    List<PaymentTransaction> findAllByRegularPaymentId(@Param("paymentId") Long paymentId);

    @Query("SELECT pt FROM PaymentTransaction pt JOIN FETCH pt.regularPayment rp WHERE pt.id = :id")
    Optional<PaymentTransaction> findByID(@Param("id") Long id);
}
