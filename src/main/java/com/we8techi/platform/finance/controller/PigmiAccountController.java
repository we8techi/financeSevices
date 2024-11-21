package com.we8techi.platform.finance.controller;

import com.we8techi.platform.finance.objects.PigmiAccountDTO;
import com.we8techi.platform.finance.service.PigmiAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Slf4j
//@PreAuthorize("isAuthenticated() and " + "hasAnyAuthority('ADMIN','USER', 'SUPER_ADMIN')")
@RestController
@RequestMapping("/api/pigmi-accounts")
public class PigmiAccountController {

    private final PigmiAccountService pigmiAccountService;

    @Autowired
    public PigmiAccountController(PigmiAccountService pigmiAccountService) {
        this.pigmiAccountService = pigmiAccountService;
    }

    @PostMapping
    public ResponseEntity<PigmiAccountDTO> createPigmiAccount(@RequestBody PigmiAccountDTO pigmiAccountDTO) {
        PigmiAccountDTO createdAccount = pigmiAccountService.createPigmiAccount(pigmiAccountDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PigmiAccountDTO> getPigmiAccountById(@PathVariable Long id) {
        PigmiAccountDTO account = pigmiAccountService.getPigmiAccountById(id);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PigmiAccountDTO>> getAllPigmiAccounts() {
        List<PigmiAccountDTO> accounts = pigmiAccountService.getAllPigmiAccount();
        return ResponseEntity.ok(accounts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PigmiAccountDTO> updatePigmiAccount(@PathVariable Long id, @RequestBody PigmiAccountDTO updatedAccount) {
        PigmiAccountDTO updatedPigmiAccount = pigmiAccountService.updatePigmiAccount(id, updatedAccount);
        if (updatedPigmiAccount != null) {
            return ResponseEntity.ok(updatedPigmiAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePigmiAccount(@PathVariable Long id) {
        pigmiAccountService.deletePigmiAccount(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<PigmiAccountDTO>> getPigmiAccountsByCustomerId(@PathVariable Long customerId) {
        List<PigmiAccountDTO> accounts = pigmiAccountService.getPigmiAccountByCustomerId(customerId);
        return ResponseEntity.ok(accounts);
    }
}
