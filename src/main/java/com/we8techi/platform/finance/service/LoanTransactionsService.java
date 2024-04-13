package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.entity.LoanTransactions;
import com.we8techi.platform.finance.objects.LoanTransactionsDTO;
import com.we8techi.platform.finance.objects.PigmiAccountDTO;

import java.util.List;

public interface LoanTransactionsService {
    LoanTransactionsDTO createLoanTransaction(LoanTransactionsDTO loanTransaction);

    LoanTransactionsDTO getLoanTransactionById(Long id);

    List<LoanTransactionsDTO> getAllLoanTransactions();

    LoanTransactionsDTO updateLoanTransaction(Long id, LoanTransactionsDTO updatedLoanTransaction);

    void deleteLoanTransaction(Long id);

    List<LoanTransactionsDTO> getLoanTransactionsByLoanAccountId(Long loanAccountId);

}

