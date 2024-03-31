package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.LoanTransactions;
import com.we8techi.platform.finance.repository.LoanTransactionsRepository;
import com.we8techi.platform.finance.service.LoanTransactionsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoanTransactionsServiceImpl implements LoanTransactionsService {
    private final LoanTransactionsRepository loanTransactionRepository;

    public LoanTransactionsServiceImpl(LoanTransactionsRepository loanTransactionRepository) {
        this.loanTransactionRepository = loanTransactionRepository;
    }

    public LoanTransactions createLoanTransaction(LoanTransactions loanTransaction) {
        return loanTransactionRepository.save(loanTransaction);
    }

    public LoanTransactions getLoanTransactionById(Long id) {
        return loanTransactionRepository.findById(id).orElse(null);
    }

    public List<LoanTransactions> getAllLoanTransactions() {
        return loanTransactionRepository.findAll();
    }

    public LoanTransactions updateLoanTransaction(Long id, LoanTransactions updatedLoanTransaction) {
        LoanTransactions existingLoanTransaction = loanTransactionRepository.findById(id).orElse(null);
        if (existingLoanTransaction != null) {
            // Update fields as needed
            // e.g., existingLoanTransaction.setAmount(updatedLoanTransaction.getAmount());
            return loanTransactionRepository.save(existingLoanTransaction);
        }
        return null;
    }

    public void deleteLoanTransaction(Long id) {
        loanTransactionRepository.deleteById(id);
    }

    @Override
    public List<LoanTransactions> getLoanTransactionsByLoanAccountId(Long loanAccountId) {
        return loanTransactionRepository.findByLoanAccountId(loanAccountId);
    }

}
