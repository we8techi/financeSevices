package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.objects.IncomeDTO;

import java.util.List;
import java.util.Optional;

public interface IncomeService {

    IncomeDTO saveIncome(IncomeDTO incomeDTO);

    Optional<IncomeDTO> getIncomeById(Long id);

    List<IncomeDTO> getAllIncomes();

    IncomeDTO updateIncome(Long id, IncomeDTO incomeDTO);

    void deleteIncome(Long id);
}




