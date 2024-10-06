package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.Expense;
import com.we8techi.platform.finance.mapper.ExpenseMapper;
import com.we8techi.platform.finance.objects.ExpenseDTO;
import com.we8techi.platform.finance.repository.ExpenseRepository;
import com.we8techi.platform.finance.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseMapper expenseMapper;

    @Override
    public ExpenseDTO saveExpense(ExpenseDTO expenseDTO) {
        Expense expense = expenseMapper.toEntity(expenseDTO);
        Expense savedExpense = expenseRepository.save(expense);
        return expenseMapper.toDto(savedExpense);
    }

    @Override
    public Optional<ExpenseDTO> getExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        return expense.map(expenseMapper::toDto);
    }

    @Override
    public List<ExpenseDTO> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream().map(expenseMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO) {
        return expenseRepository.findById(id).map(existingExpense -> {
            expenseMapper.toEntity(expenseDTO); // Update entity with DTO values
            existingExpense.setUpdatedAt(LocalDateTime.now());
            Expense updatedExpense = expenseRepository.save(existingExpense);
            return expenseMapper.toDto(updatedExpense);
        }).orElseThrow(() -> new RuntimeException("Expense not found with id " + id));
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }


}


