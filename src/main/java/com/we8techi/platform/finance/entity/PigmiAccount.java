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
@Table(name = "pigmi_account")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PigmiAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "interest_rate")
    private Double interestRate;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "payment_details")
    private String paymentDetails;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "number_of_days")
    private Integer numberOfDays;

    @Column(name = "pigmi_status")
    private String pigmiStatus;

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
