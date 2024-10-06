package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.objects.ExpenseDTO;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {

    ExpenseDTO saveExpense(ExpenseDTO expenseDTO);

    Optional<ExpenseDTO> getExpenseById(Long id);

    List<ExpenseDTO> getAllExpenses();

    ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO);

    void deleteExpense(Long id);
}

