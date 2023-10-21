package com.we8techi.platform.finance.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dhijadhav
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanCalRequest {
    private Double principleAmount;
    private Double interestRate;
    private Integer numberOfDays;
}
