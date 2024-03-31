package com.we8techi.platform.finance.controller;
import java.util.List;

import com.we8techi.platform.finance.entity.LoanTransactions;
import com.we8techi.platform.finance.service.LoanTransactionsService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/loan-transactions")
public class LoanTransactionsController {
    private final LoanTransactionsService loanTransactionsService;

    public LoanTransactionsController(LoanTransactionsService loanTransactionsService) {
        this.loanTransactionsService = loanTransactionsService;
    }

    @PostMapping
    public LoanTransactions createLoanTransaction(@RequestBody LoanTransactions loanTransaction) {
        return loanTransactionsService.createLoanTransaction(loanTransaction);
    }

    @GetMapping("/{id}")
    public LoanTransactions getLoanTransactionById(@PathVariable Long id) {
        return loanTransactionsService.getLoanTransactionById(id);
    }

    @GetMapping
    public List<LoanTransactions> getAllLoanTransactions() {
        return loanTransactionsService.getAllLoanTransactions();
    }

    @PutMapping("/{id}")
    public LoanTransactions updateLoanTransaction(@PathVariable Long id, @RequestBody LoanTransactions updatedLoanTransaction) {
        return loanTransactionsService.updateLoanTransaction(id, updatedLoanTransaction);
    }

    @DeleteMapping("/{id}")
    public void deleteLoanTransaction(@PathVariable Long id) {
        loanTransactionsService.deleteLoanTransaction(id);
    }

    @GetMapping("/by-loan-account/{loanAccountId}")
    public List<LoanTransactions> getLoanTransactionsByLoanAccountId(@PathVariable Long loanAccountId) {
        return loanTransactionsService.getLoanTransactionsByLoanAccountId(loanAccountId);
    }

}
