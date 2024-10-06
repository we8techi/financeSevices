package com.we8techi.platform.finance.objects;

import java.time.LocalDate;

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

    public LoanCalResponse(LocalDate collectionStartDate, Double perDayInterest, Double thirtyDaysInterest, Double issueAmount, Double passbookCharge, LocalDate collectionStartDate1, String d, double v, Double perDayInterest1, double v1) {
    }
}
