package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.Income;
import com.we8techi.platform.finance.mapper.IncomeMapper;
import com.we8techi.platform.finance.objects.IncomeDTO;
import com.we8techi.platform.finance.repository.IncomeRepository;
import com.we8techi.platform.finance.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private IncomeMapper incomeMapper;

    @Override
    public IncomeDTO saveIncome(IncomeDTO incomeDTO) {
        Income income = incomeMapper.toEntity(incomeDTO);
        Income savedIncome = incomeRepository.save(income);
        return incomeMapper.toDto(savedIncome);
    }

    @Override
    public Optional<IncomeDTO> getIncomeById(Long id) {
        Optional<Income> income = incomeRepository.findById(id);
        return income.map(incomeMapper::toDto);
    }

    @Override
    public List<IncomeDTO> getAllIncomes() {
        List<Income> incomes = incomeRepository.findAll();
        return incomes.stream().map(incomeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public IncomeDTO updateIncome(Long id, IncomeDTO incomeDTO) {
        return incomeRepository.findById(id).map(existingIncome -> {
            incomeMapper.toEntity(incomeDTO); // Update entity with DTO values
            existingIncome.setUpdatedAt(LocalDateTime.now());
            Income updatedIncome = incomeRepository.save(existingIncome);
            return incomeMapper.toDto(updatedIncome);
        }).orElseThrow(() -> new RuntimeException("Income not found with id " + id));
    }

    @Override
    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
}


