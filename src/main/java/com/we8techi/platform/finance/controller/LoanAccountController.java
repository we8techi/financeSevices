package com.we8techi.platform.finance.controller;

import com.we8techi.platform.finance.entity.LoanAccount;
import com.we8techi.platform.finance.objects.LoanCalRequest;
import com.we8techi.platform.finance.service.LoanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/loan-accounts")
@PreAuthorize("isAuthenticated() and " + "hasAuthority('ADMIN')")
public class LoanAccountController {

    private final LoanService loanAccountService;

    @Autowired
    public LoanAccountController(LoanService loanAccountService) {
        this.loanAccountService = loanAccountService;
    }
    @PostMapping
    public LoanAccount createLoanAccount(@RequestBody LoanAccount loanAccount) {
        return loanAccountService.createLoanAccount(loanAccount);
    }

    @GetMapping("/{id}")
    public LoanAccount getLoanAccountById(@PathVariable Long id) {
        return loanAccountService.getLoanAccountById(id);
    }

    @GetMapping
    public List<LoanAccount> getAllLoanAccounts() {
        return loanAccountService.getAllLoanAccounts();
    }

    @PutMapping("/{id}")
    public LoanAccount updateLoanAccount(@PathVariable Long id, @RequestBody LoanAccount updatedLoanAccount) {
        return loanAccountService.updateLoanAccount(id, updatedLoanAccount);
    }

    @DeleteMapping("/{id}")
    public void deleteLoanAccount(@PathVariable Long id) {
        loanAccountService.deleteLoanAccount(id);
    }
    @PostMapping("/loan/calculate")
    public ResponseEntity<Double> registerUser(@RequestBody LoanCalRequest loanCalRequest) {
        log.info("Inside Loan controller.......");

        Double result = loanAccountService.calculateLoanAmount(loanCalRequest);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/by-customer/{customerId}")
    public List<LoanAccount> getLoansByCustomerId(@PathVariable Long customerId) {
        return loanAccountService.getLoansByCustomerId(customerId);
    }


}
