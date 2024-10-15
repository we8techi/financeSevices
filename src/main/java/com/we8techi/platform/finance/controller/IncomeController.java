package com.we8techi.platform.finance.controller;

import com.we8techi.platform.finance.objects.IncomeDTO;
import com.we8techi.platform.finance.service.IncomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Slf4j
//@PreAuthorize("isAuthenticated() and " + "hasAnyAuthority('ADMIN','USER', 'SUPER_ADMIN')")
@RestController
@RequestMapping("/api/{companyId}/incomes")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @PostMapping
    public ResponseEntity<IncomeDTO> createIncome(@PathVariable("companyId") Long companyId,@RequestBody IncomeDTO incomeDTO) {
        IncomeDTO createdIncome = incomeService.saveIncome(companyId,incomeDTO);
        return new ResponseEntity<>(createdIncome, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeDTO> getIncomeById(@PathVariable("companyId") Long companyId,@PathVariable Long id) {
        Optional<IncomeDTO> incomeDTO = incomeService.getIncomeById(companyId,id);
        return incomeDTO.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<IncomeDTO>> getAllIncomes(@PathVariable("companyId") Long companyId) {
        List<IncomeDTO> incomes = incomeService.getAllIncomes(companyId);
        return new ResponseEntity<>(incomes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncomeDTO> updateIncome(Long companyId,@PathVariable Long id, @RequestBody IncomeDTO incomeDTO) {
        try {
            IncomeDTO updatedIncome = incomeService.updateIncome(companyId,id, incomeDTO);
            return new ResponseEntity<>(updatedIncome, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(Long companyId,@PathVariable Long id) {
        try {
            incomeService.deleteIncome(companyId,id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
