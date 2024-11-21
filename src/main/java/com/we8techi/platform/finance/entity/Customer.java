package com.we8techi.platform.finance.entity;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dhijadhav
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "customer_type")
    private String customerType;

    @Column(name = "mobile_no")
    private String mobileNumber;

    @Column(name = "area")
    private String area;

    @Column(name = "score")
    private Integer score;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "pan_details")
    private String panDetails;

    @Column(name = "aadhar_details")
    private String adharDetails;

    @Column(name = "address_proof")
    private String addressProof;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private String pincode;

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