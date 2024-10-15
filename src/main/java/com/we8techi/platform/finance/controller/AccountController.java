package com.we8techi.platform.finance.controller;

import com.we8techi.platform.finance.entity.Account;
import com.we8techi.platform.finance.objects.CustomerDTO;
import com.we8techi.platform.finance.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/{companyId}")
//@PreAuthorize("isAuthenticated() and " + "hasAnyAuthority('ADMIN','USER', 'SUPER_ADMIN')")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@PathVariable("companyId") Long companyId, @RequestBody Account account) {
        log.info("Inside create a account .......");
        Account accountDTO = accountService.createAccount(account);
        return new ResponseEntity<>(accountDTO, HttpStatus.CREATED);
    }

    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable("accountId") Long accountId) {
        log.info("Fetch account details by accountId....");
        Account accountDTO = accountService.getAccount(accountId);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @PutMapping("/accounts/{accountId}")
    public ResponseEntity<Account> updateAccount(@PathVariable("accountId") Long accountId,@RequestBody Account account) {
        log.info("Inside update a account ....");
        Account accountDTO = accountService.updateAccount(accountId,account);
        return new ResponseEntity<>(accountDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable("id") Long accountId) {
        log.info("Inside delete account ...");
        try {
            accountService.deleteAccount(accountId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
