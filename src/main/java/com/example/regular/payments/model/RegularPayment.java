package com.example.regular.payments.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@Table(name = "regular_payments")
@SQLDelete(sql = "UPDATE regular_payments SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted = false")
public class RegularPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "INN", nullable = false)
    private String INN;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "recipient_account", nullable = false)
    private String recipientAccount;

    @Column(name = "recipient_MFO", nullable = false)
    private String recipientMFO;

    @Column(name = "recipient_OKPO", nullable = false)
    private String recipientOKPO;

    @Column(name = "recipient_name", nullable = false)
    private String recipientName;

    @Column(name = "payment_period")
    private int paymentPeriod;

    @Column(name = "payment_amount")
    private double paymentAmount;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;
}
