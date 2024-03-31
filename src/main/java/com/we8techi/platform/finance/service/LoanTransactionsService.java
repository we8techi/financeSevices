package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.entity.LoanTransactions;

import java.util.List;

public interface LoanTransactionsService {
    LoanTransactions createLoanTransaction(LoanTransactions loanTransaction);

    LoanTransactions getLoanTransactionById(Long id);

    List<LoanTransactions> getAllLoanTransactions();

    LoanTransactions updateLoanTransaction(Long id, LoanTransactions updatedLoanTransaction);

    void deleteLoanTransaction(Long id);

    List<LoanTransactions> getLoanTransactionsByLoanAccountId(Long loanAccountId);

}
