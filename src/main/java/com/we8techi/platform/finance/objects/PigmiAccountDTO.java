package com.we8techi.platform.finance.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PigmiAccountDTO {


    private Long id;

    private Long customerId;


    private Double interestRate;


    private Double amount;


    private String paymentDetails;


    private String paymentMode;


    private Integer numberOfDays;


    private String pigmiStatus;


    private Boolean active;


    private Date created;


    private String createdBy;


    private Date updated;


    private String updatedBy;

}

