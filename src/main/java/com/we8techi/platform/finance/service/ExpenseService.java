package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.objects.ExpenseDTO;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {

    ExpenseDTO saveExpense(Long companyId,ExpenseDTO expenseDTO);

    Optional<ExpenseDTO> getExpenseById(Long companyId,Long id);

    List<ExpenseDTO> getAllExpenses(Long companyId);

    ExpenseDTO updateExpense(Long companyId,Long id, ExpenseDTO expenseDTO);

    void deleteExpense(Long companyId,Long id);
}

