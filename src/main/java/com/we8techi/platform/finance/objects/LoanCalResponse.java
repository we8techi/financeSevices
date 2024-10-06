package com.we8techi.platform.finance.objects;

import java.time.LocalDate;

public record LoanCalResponse(LocalDate returnDate, 
                              Double perDayInterestAmount, 
                              Double monthlyInterestAmount,
                              Double issueAmount, 
                              Double passbookCharges,
                              LocalDate collectionFrom, 
                              String loanType,
                              Double totalCollectionAmount,
                              Double dailyCollectionAmount,
                              Double monthlyCollectionAmount) {


}
