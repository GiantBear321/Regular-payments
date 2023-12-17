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
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "INN")
    private String INN;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "recipient_account")
    private String recipientAccount;

    @Column(name = "recipient_MFO")
    private String recipientMFO;

    @Column(name = "recipient_OKPO")
    private String recipientOKPO;

    @Column(name = "recipient_name")
    private String recipientName;

    @Column(name = "payment_period")
    private int paymentPeriod;

    @Column(name = "payment_amount")
    private double paymentAmount;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;
}
