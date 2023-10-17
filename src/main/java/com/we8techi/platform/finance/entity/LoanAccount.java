package com.we8techi.platform.finance.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author dhijadhav
 */

@Getter
@Setter
@Entity
@Table(name = "loan_account")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "interest_rate")
    private Double interestRate;

    @Column(name = "principal_amount")
    private Double principalAmount;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "collected_amount")
    private Double collectedAmount;

    @Column(name = "payment_details")
    private String paymentDetails;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "number_of_days")
    private Integer numberOfDays;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "loan_status")
    private String loanStatus;

    @Column(name = "active", updatable = false, nullable = false)
    private Boolean active;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", updatable = false, nullable = false)
    @CreatedDate
    private Date created;

    @Column(name = "created_by", updatable = false, nullable = false)
    @CreatedBy
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    @LastModifiedDate
    private Date updated;

    @Column(name = "updated_by")
    @LastModifiedBy
    private String updatedBy;

}
