package com.we8techi.platform.finance.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanAccountDTO {

    private Long id;
    private Long customerId;
    private Double interestRate;
    private Double principalAmount;
    private Double totalAmount;
    private Double collectedAmount;
    private String paymentDetails;
    private String paymentMode;
    private Integer numberOfDays;
    private String loanType;
    private String loanStatus;
    private Boolean active;
    private Date created;
    private String createdBy;
    private Date updated;
    private String updatedBy;

}

