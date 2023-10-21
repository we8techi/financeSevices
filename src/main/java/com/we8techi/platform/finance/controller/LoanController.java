package com.we8techi.platform.finance.controller;

import com.we8techi.platform.finance.objects.LoanCalRequest;
import com.we8techi.platform.finance.service.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@PreAuthorize("isAuthenticated() and " + "hasAuthority('ADMIN')")
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/loan/calculate")
    public ResponseEntity<Double> registerUser(@RequestBody LoanCalRequest loanCalRequest) {
        log.info("Inside Loan controller.......");

        Double result = loanService.calculateLoanAmount(loanCalRequest);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
