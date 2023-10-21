package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.objects.LoanCalRequest;

public interface LoanService {

    /**
     * Calculate the Loan based on request
     * @param loanCalRequest
     * @return final loan amount with principle + Interest amount
     */
    Double calculateLoanAmount(LoanCalRequest loanCalRequest);
}
