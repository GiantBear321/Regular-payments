package com.example.regular.payments.repository;

import com.example.regular.payments.model.RegularPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegularPaymentRepository extends JpaRepository<RegularPayment, Long> {
    List<RegularPayment> findRegularPaymentByNameAndSurname(String name, String surname);

    List<RegularPayment> findByINN(String INN);

    List<RegularPayment> findByRecipientAccount(String recipientAccount);

    List<RegularPayment> findByRecipientName(String recipientName);

}
