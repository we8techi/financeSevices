package com.we8techi.platform.finance.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanCalResponse {

    LocalDate returnDate;
    Double perDayInterestAmount;
    Double monthlyInterestAmount;
    Double issueAmount;
    Double passbookCharges;
    LocalDate collectionFrom;
    String loanType;
    Double totalCollectionAmount;
    Double dailyCollectionAmount;
    Double monthlyCollectionAmount;

}
