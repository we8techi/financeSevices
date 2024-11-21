package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.Customer;
import com.we8techi.platform.finance.entity.Expense;
import com.we8techi.platform.finance.entity.Income;
import com.we8techi.platform.finance.exception.ApplicationException;
import com.we8techi.platform.finance.mapper.CustomerMapper;
import com.we8techi.platform.finance.mapper.IncomeMapper;
import com.we8techi.platform.finance.objects.IncomeDTO;
import com.we8techi.platform.finance.repository.IncomeRepository;
import com.we8techi.platform.finance.service.IncomeService;
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
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private IncomeMapper incomeMapper;

    @Override
    public IncomeDTO saveIncome(Long companyId,IncomeDTO incomeDTO) {
        log.info("Add Income for a companyId={}", companyId);
        Income income = incomeMapper.toEntity(incomeDTO);
        Income savedIncome = incomeRepository.save(income);
        log.info("Income added successfully.");
        return incomeMapper.toDto(savedIncome);

        /*Income income = incomeMapper.toEntity(incomeDTO);
        Income savedIncome = incomeRepository.save(income);
        return incomeMapper.toDto(savedIncome);*/
    }

    @Override
    public Optional<IncomeDTO> getIncomeById(Long companyId,Long id) {
        Optional<Income> income = incomeRepository.findById(id);
        return income.map(incomeMapper::toDto);
    }

    @Override
    public List<IncomeDTO> getAllIncomes(Long companyId) {
        List<Income> incomes = incomeRepository.findAll();
        return incomes.stream().map(incomeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public IncomeDTO updateIncome(Long companyId,Long id, IncomeDTO incomeDTO) {
        boolean isUpdatable = true;
        Income UpdatedIncome = null;
        if(Objects.isNull(incomeDTO.getId()) || Objects.isNull(incomeDTO.getCompanyId()) ) {
            isUpdatable = false;
        }
        if(isUpdatable) {
            Optional<Income> result = incomeRepository.findById(id);
            if (result.isPresent()) {
                log.info("Income updating...");
                Income income = incomeMapper.toEntity(incomeDTO);
                UpdatedIncome = incomeRepository.save(income);
                
            }else {
                log.error("Invalid income details.");
                throw new ApplicationException("Invalid Income details.", HttpStatus.BAD_REQUEST);
            }
        }
        return incomeMapper.toDto(UpdatedIncome);
    }

    @Override
    public void deleteIncome(Long companyId,Long id) {
        incomeRepository.deleteById(id);
    }
}
