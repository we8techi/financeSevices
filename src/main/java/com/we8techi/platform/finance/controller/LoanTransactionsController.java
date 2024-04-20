package com.we8techi.platform.finance.controller;
import java.util.List;

import com.we8techi.platform.finance.objects.LoanTransactionsDTO;
import com.we8techi.platform.finance.service.LoanTransactionsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/loan-transactions")
//@PreAuthorize("isAuthenticated() and " + "hasAnyAuthority('ADMIN','USER', 'SUPER_ADMIN')")
public class LoanTransactionsController {
    private final LoanTransactionsService loanTransactionsService;

    public LoanTransactionsController(LoanTransactionsService loanTransactionsService) {
        this.loanTransactionsService = loanTransactionsService;
    }

    @PostMapping
    public LoanTransactionsDTO createLoanTransaction(@RequestBody LoanTransactionsDTO loanTransaction) {
        return loanTransactionsService.createLoanTransaction(loanTransaction);
    }

    @GetMapping("/{id}")
    public LoanTransactionsDTO getLoanTransactionById(@PathVariable Long id) {
        return loanTransactionsService.getLoanTransactionById(id);
    }

    @GetMapping
    public List<LoanTransactionsDTO> getAllLoanTransactions() {
        return loanTransactionsService.getAllLoanTransactions();
    }

    @PutMapping("/{id}")
    public LoanTransactionsDTO updateLoanTransaction(@PathVariable Long id, @RequestBody LoanTransactionsDTO updatedLoanTransaction) {
        return loanTransactionsService.updateLoanTransaction(id, updatedLoanTransaction);
    }

    @DeleteMapping("/{id}")
    public void deleteLoanTransaction(@PathVariable Long id) {
        loanTransactionsService.deleteLoanTransaction(id);
    }

    @GetMapping("/by-loan-account/{loanAccountId}")
    public List<LoanTransactionsDTO> getLoanTransactionsByLoanAccountId(@PathVariable Long loanAccountId) {
        return loanTransactionsService.getLoanTransactionsByLoanAccountId(loanAccountId);
    }

}
