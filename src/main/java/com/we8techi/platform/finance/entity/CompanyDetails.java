package com.we8techi.platform.finance.entity;

import lombok.*;

import javax.persistence.*;

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
public class CompanyDetails extends BaseEntity {
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
}
