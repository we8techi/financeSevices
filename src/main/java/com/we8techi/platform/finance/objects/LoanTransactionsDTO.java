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
public class LoanTransactionsDTO {


    private Long id;

    private Long loanAccountId;

    private String transactionId;

    private Double amount;

    private String paymentDetails;

    private String paymentMode;

    private Boolean active;

    private Date created;

    private String createdBy;

    private Date updated;

    private String updatedBy;
}
