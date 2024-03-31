package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.entity.LoanAccount;
import com.we8techi.platform.finance.objects.LoanCalRequest;

import java.util.List;

public interface LoanService {

    /**
     * Calculate the Loan based on request
     * @param loanCalRequest
     * @return final loan amount with principle + Interest amount
     */
    Double calculateLoanAmount(LoanCalRequest loanCalRequest);

    LoanAccount createLoanAccount(LoanAccount loanAccount);

    LoanAccount getLoanAccountById(Long id);

    List<LoanAccount> getAllLoanAccounts();

    LoanAccount updateLoanAccount(Long id, LoanAccount updatedLoanAccount);

    void deleteLoanAccount(Long id);

    List<LoanAccount> getLoansByCustomerId(Long customerId);
}
