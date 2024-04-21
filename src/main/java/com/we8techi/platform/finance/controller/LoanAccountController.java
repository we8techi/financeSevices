package com.we8techi.platform.finance.controller;

import com.we8techi.platform.finance.objects.LoanAccountDTO;
import com.we8techi.platform.finance.objects.LoanCalRequest;
import com.we8techi.platform.finance.service.LoanAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api/loan-accounts")
//@PreAuthorize("isAuthenticated() and " + "hasAnyAuthority('ADMIN','USER', 'SUPER_ADMIN')")
public class LoanAccountController {

    private final LoanAccountService loanAccountService;

    public LoanAccountController(LoanAccountService loanAccountService) {
        this.loanAccountService = loanAccountService;
    }


    @PostMapping
    public LoanAccountDTO createLoanAccount(@RequestBody LoanAccountDTO loanAccountDTO) {
        return loanAccountService.createLoanAccount(loanAccountDTO);
    }

    @GetMapping("/{id}")
    public LoanAccountDTO getLoanAccountById(@PathVariable Long id) {
        if (id == 0) {
            return createSampleLoanAccount();
        } else {
            return loanAccountService.getLoanAccountById(id);
        }
    }

    private LoanAccountDTO createSampleLoanAccount() {
        LoanAccountDTO sampleLoanAccount = new LoanAccountDTO();
        sampleLoanAccount.setId(0L);
        sampleLoanAccount.setCustomerId(123L);
        sampleLoanAccount.setInterestRate(5.0);
        sampleLoanAccount.setPrincipalAmount(10000.0);
        sampleLoanAccount.setTotalAmount(11000.0);
        sampleLoanAccount.setCollectedAmount(0.0);
        sampleLoanAccount.setPaymentDetails("Payment details...");
        sampleLoanAccount.setPaymentMode("Cash");
        sampleLoanAccount.setNumberOfDays(30);
        sampleLoanAccount.setLoanType("Personal");
        sampleLoanAccount.setLoanStatus("Active");
        sampleLoanAccount.setActive(true);
        sampleLoanAccount.setCreated(new Date());
        sampleLoanAccount.setCreatedBy("Admin");
        sampleLoanAccount.setUpdated(new Date());
        sampleLoanAccount.setUpdatedBy("Admin");
        return sampleLoanAccount;
    }


    @GetMapping
    public List<LoanAccountDTO> getAllLoanAccounts() {
        return loanAccountService.getAllLoanAccounts();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLoanAccount(@PathVariable Long id, @RequestBody LoanAccountDTO updatedLoanAccountDTO) {
        LoanAccountDTO updatedLoanAccount = loanAccountService.updateLoanAccount(id, updatedLoanAccountDTO);
        if (updatedLoanAccount != null) {
            return ResponseEntity.ok(updatedLoanAccount);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Loan account not found with ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLoanAccount(@PathVariable Long id) {
        loanAccountService.deleteLoanAccount(id);
        return ResponseEntity.status(HttpStatus.OK).body("Loan account # " + id + " is deleted successfully! " );
    }
    @PostMapping("/loan/calculate")
    public ResponseEntity<Double> registerUser(@RequestBody LoanCalRequest loanCalRequest) {
        log.info("Inside Loan controller.......");

        Double result = loanAccountService.calculateLoanAmount(loanCalRequest);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/by-customer/{customerId}")
    public List<LoanAccountDTO> getLoansByCustomerId(@PathVariable Long customerId) {
        return loanAccountService.getLoansByCustomerId(customerId);
    }
}
