package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.objects.PigmiTransactionsDTO;

import java.util.List;

public interface PigmiTransactionsService {
    PigmiTransactionsDTO createPigmiTransactions(PigmiTransactionsDTO loanTransaction);

    PigmiTransactionsDTO updatePigmiTransactions(Long id, PigmiTransactionsDTO updatedLoanTransaction);

    void deletePigmiTransactions(Long id);

    List<PigmiTransactionsDTO> getAllPigmiTransactionsdByAccountId(Long id);

    List<PigmiTransactionsDTO> getPigmiTransactionsByCustomerId(Long loanAccountId);

}
