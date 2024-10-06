package com.we8techi.platform.finance.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "income")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Income implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "source")
    private String source;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "receiving_account")
    private String receivingAccount;

    @Column(name = "payer_name")
    private String payerName;

    @Column(name = "date_received")
    private LocalDate dateReceived;

    @Column(name = "description")
    private String description;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "currency")
    private String currency;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
