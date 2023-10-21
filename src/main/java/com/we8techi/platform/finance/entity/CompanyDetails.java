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
@Table(name = "company_details")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "details")
    private String details;

    @Column(name = "company_address")
    private String companyAddress;

    @Column(name = "is_mobile_access", nullable = false)
    private Boolean mobileAccess;

    @Column(name = "is_web_access", nullable = false)
    private Boolean webAccess;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "valid_from", nullable = false)
    private Date validFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "valid_till", nullable = false)
    private Date validTill;

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
