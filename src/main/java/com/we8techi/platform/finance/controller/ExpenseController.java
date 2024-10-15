package com.we8techi.platform.finance.controller;

import com.we8techi.platform.finance.objects.ExpenseDTO;
import com.we8techi.platform.finance.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Slf4j
@PreAuthorize("isAuthenticated() and " + "hasAnyAuthority('ADMIN','USER', 'SUPER_ADMIN')")
@RestController
@RequestMapping("/api//{companyId}expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseDTO> createExpense(@PathVariable("companyId") Long companyId,@RequestBody ExpenseDTO expenseDTO) {
        ExpenseDTO createdExpense = expenseService.saveExpense(companyId,expenseDTO);
        return new ResponseEntity<>(createdExpense, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDTO> getExpenseById(@PathVariable("companyId") Long companyId,@PathVariable Long id) {
        Optional<ExpenseDTO> expenseDTO = expenseService.getExpenseById(companyId,id);
        return expenseDTO.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDTO>> getAllExpenses(@PathVariable("companyId") Long companyId) {
        List<ExpenseDTO> expenses = expenseService.getAllExpenses(companyId);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDTO> updateExpense(@PathVariable("companyId") Long companyId,@PathVariable Long id, @RequestBody ExpenseDTO expenseDTO) {
        try {
            ExpenseDTO updatedExpense = expenseService.updateExpense(companyId, id, expenseDTO);
            return new ResponseEntity<>(updatedExpense, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable("companyId") Long companyId,@PathVariable Long id) {
        try {
            expenseService.deleteExpense(companyId,id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

