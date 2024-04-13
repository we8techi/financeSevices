package com.we8techi.platform.finance.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
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

