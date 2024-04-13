package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.objects.LoanAccountDTO;
import com.we8techi.platform.finance.objects.LoanCalRequest;
import java.util.List;

public interface LoanAccountService {

    /**
     * Calculate the Loan based on request
     * @param loanCalRequest
     * @return final loan amount with principle + Interest amount
     */
    Double calculateLoanAmount(LoanCalRequest loanCalRequest);

    LoanAccountDTO createLoanAccount(LoanAccountDTO loanAccountDTO);

    LoanAccountDTO getLoanAccountById(Long id);

    List<LoanAccountDTO> getAllLoanAccounts();

    LoanAccountDTO updateLoanAccount(Long id, LoanAccountDTO updatedLoanAccountDTO);

    void deleteLoanAccount(Long id);

    List<LoanAccountDTO> getLoansByCustomerId(Long customerId);
}
