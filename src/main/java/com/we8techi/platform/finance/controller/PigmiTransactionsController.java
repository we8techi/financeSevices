package com.we8techi.platform.finance.controller;


import com.we8techi.platform.finance.objects.PigmiTransactionsDTO;
import com.we8techi.platform.finance.service.PigmiTransactionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@PreAuthorize("isAuthenticated() and " + "hasAnyAuthority('ADMIN','USER', 'SUPER_ADMIN')")
@RestController
@RequestMapping("/api/pigmi-transactions")
public class PigmiTransactionsController {

    private final PigmiTransactionsService pigmiTransactionsService;

    @Autowired
    public PigmiTransactionsController(PigmiTransactionsService pigmiTransactionsService) {
        this.pigmiTransactionsService = pigmiTransactionsService;
    }

    @PostMapping
    public ResponseEntity<PigmiTransactionsDTO> createPigmiTransaction(@RequestBody PigmiTransactionsDTO pigmiTransactionsDTO) {
        PigmiTransactionsDTO createdTransaction = pigmiTransactionsService.createPigmiTransactions(pigmiTransactionsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PigmiTransactionsDTO> updatePigmiTransaction(@PathVariable Long id, @RequestBody PigmiTransactionsDTO updatedTransaction) {
        PigmiTransactionsDTO updatedPigmiTransaction = pigmiTransactionsService.updatePigmiTransactions(id, updatedTransaction);
        if (updatedPigmiTransaction != null) {
            return ResponseEntity.ok(updatedPigmiTransaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePigmiTransaction(@PathVariable Long id) {
        pigmiTransactionsService.deletePigmiTransactions(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<List<PigmiTransactionsDTO>> getAllPigmiTransactionsByAccountId(@PathVariable Long id) {
        List<PigmiTransactionsDTO> transactions = pigmiTransactionsService.getAllPigmiTransactionsdByAccountId(id);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<PigmiTransactionsDTO>> getPigmiTransactionsByCustomerId(@PathVariable Long customerId) {
        List<PigmiTransactionsDTO> transactions = pigmiTransactionsService.getPigmiTransactionsByCustomerId(customerId);
        return ResponseEntity.ok(transactions);
    }
}
