package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.objects.IncomeDTO;

import java.util.List;
import java.util.Optional;

public interface IncomeService {

    IncomeDTO saveIncome(Long companyId,IncomeDTO incomeDTO);

    Optional<IncomeDTO> getIncomeById(Long companyId,Long id);

    List<IncomeDTO> getAllIncomes(Long companyId);

    IncomeDTO updateIncome(Long companyId,Long id, IncomeDTO incomeDTO);

    void deleteIncome(Long companyId,Long id);
}
