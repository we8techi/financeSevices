package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.Expense;
import com.we8techi.platform.finance.exception.ApplicationException;
import com.we8techi.platform.finance.mapper.ExpenseMapper;
import com.we8techi.platform.finance.objects.ExpenseDTO;
import com.we8techi.platform.finance.repository.ExpenseRepository;
import com.we8techi.platform.finance.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseMapper expenseMapper;

    @Override
    public ExpenseDTO saveExpense(Long companyId,ExpenseDTO expenseDTO) {
        Expense expense = expenseMapper.toEntity(expenseDTO);
        Expense savedExpense = expenseRepository.save(expense);
        return expenseMapper.toDto(savedExpense);
    }

    @Override
    public Optional<ExpenseDTO> getExpenseById(Long companyId,Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        return expense.map(expenseMapper::toDto);
    }

    @Override
    public List<ExpenseDTO> getAllExpenses(Long companyId) {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream().map(expenseMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ExpenseDTO updateExpense(Long companyId,Long id, ExpenseDTO expenseDTO) {
        boolean isUpdatable = true;
        Expense savedExpense = null;
        if(Objects.isNull(expenseDTO.getId()) || Objects.isNull(expenseDTO.getCompanyId()) ) {
            isUpdatable = false;
        }
        if(isUpdatable) {
            Optional<Expense> result = expenseRepository.findById(id);
            if (result.isPresent()) {
                log.info("Expense updating...");
                Expense expense = expenseMapper.toEntity(expenseDTO);
                savedExpense = expenseRepository.save(expense);
                //return expenseMapper.toDto(savedExpense);
            }else {
                log.error("Invalid expense details.");
                throw new ApplicationException("Invalid expense details.", HttpStatus.BAD_REQUEST);
            }
        }
        return expenseMapper.toDto(savedExpense);
    }

    @Override
    public void deleteExpense(Long companyId,Long id) {
        expenseRepository.deleteById(id);
    }
}
