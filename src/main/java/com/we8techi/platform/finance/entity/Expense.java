package com.we8techi.platform.finance.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "expense")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Expense implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "payee_name")
    private String payeeName;

    @Column(name = "payer_account")
    private String payerAccount;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "date_spent")
    private LocalDate dateSpent;

    @Column(name = "description")
    private String description;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "company_id", nullable = false)
    private Long companyId;

}
