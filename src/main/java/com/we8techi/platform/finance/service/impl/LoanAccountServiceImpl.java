package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.LoanAccount;
import com.we8techi.platform.finance.exception.ApplicationException;
import com.we8techi.platform.finance.mapper.LoanAccountMapperFactory;
import com.we8techi.platform.finance.objects.LoanAccountDTO;
import com.we8techi.platform.finance.objects.LoanCalRequest;
import com.we8techi.platform.finance.repository.LoanAccountRepository;
import com.we8techi.platform.finance.service.LoanAccountService;
import com.we8techi.platform.finance.utils.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author dhijadhav
 */

@Slf4j
@Service
public class LoanAccountServiceImpl implements LoanAccountService {

    private final LoanAccountRepository loanAccountRepository;

    public LoanAccountServiceImpl(LoanAccountRepository loanAccountRepository) {
        this.loanAccountRepository = loanAccountRepository;
    }

    public LoanAccountDTO createLoanAccount(LoanAccountDTO loanAccountDTO) {
        LoanAccount loanAccount = LoanAccountMapperFactory.INSTANCE.toEntity(loanAccountDTO);
        return LoanAccountMapperFactory.INSTANCE.toDto(loanAccountRepository.save(loanAccount));
    }

    public LoanAccountDTO getLoanAccountById(Long id) {
        return LoanAccountMapperFactory.INSTANCE.toDto(loanAccountRepository.findById(id).orElse(null));
    }

    public List<LoanAccountDTO> getAllLoanAccounts() {
        return LoanAccountMapperFactory.INSTANCE.toDtoList(loanAccountRepository.findAll());
    }

    @Override
    public LoanAccountDTO updateLoanAccount(Long id, LoanAccountDTO updatedLoanAccountDTO) {

        Optional<LoanAccount> optionalLoanAccount = loanAccountRepository.findById(id);
        if (optionalLoanAccount.isPresent()) {
            return LoanAccountMapperFactory.INSTANCE.toDto(
                    loanAccountRepository.save(
                            LoanAccountMapperFactory.INSTANCE.toEntity(updatedLoanAccountDTO)
                    )
            );
        }
        return null;

    }

    public void deleteLoanAccount(Long id) {
        loanAccountRepository.deleteById(id);
    }

    @Override
    public List<LoanAccountDTO> getLoansByCustomerId(Long customerId) {
        return LoanAccountMapperFactory.INSTANCE.toDtoList(loanAccountRepository.findByCustomerId(customerId));
    }

    @Override
    public Double calculateLoanAmount(LoanCalRequest loanCalRequest) {
        log.info("Inside the calculate Loan Method ...!!!");
        try {
            return AppUtils.round((loanCalRequest.getPrincipleAmount() * loanCalRequest.getNumberOfDays() * loanCalRequest.getInterestRate()) / (100 * 365), 2);
        } catch (Exception ex) {
            log.error("Exception Occurred while loan amount calculation error ={}", ex.getMessage());
            throw new ApplicationException("Exception Occurred while loan amount calculation.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
