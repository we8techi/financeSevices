package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.LoanAccount;
import com.we8techi.platform.finance.exception.ApplicationException;
import com.we8techi.platform.finance.objects.LoanCalRequest;
import com.we8techi.platform.finance.repository.LoanAccountRepository;
import com.we8techi.platform.finance.service.LoanService;
import com.we8techi.platform.finance.utils.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dhijadhav
 */

@Slf4j
@Service
public class LoanServiceImpl implements LoanService {

    private final LoanAccountRepository loanAccountRepository;

    public LoanServiceImpl(LoanAccountRepository loanAccountRepository) {
        this.loanAccountRepository = loanAccountRepository;
    }

    public LoanAccount createLoanAccount(LoanAccount loanAccount) {
        return loanAccountRepository.save(loanAccount);
    }

    public LoanAccount getLoanAccountById(Long id) {
        return loanAccountRepository.findById(id).orElse(null);
    }

    public List<LoanAccount> getAllLoanAccounts() {
        return loanAccountRepository.findAll();
    }

    public LoanAccount updateLoanAccount(Long id, LoanAccount updatedLoanAccount) {
        LoanAccount existingLoanAccount = loanAccountRepository.findById(id).orElse(null);
        if (existingLoanAccount != null) {
            // Update fields as needed
            // e.g., existingLoanAccount.setInterestRate(updatedLoanAccount.getInterestRate());
            return loanAccountRepository.save(existingLoanAccount);
        }
        return null;
    }

    public void deleteLoanAccount(Long id) {
        loanAccountRepository.deleteById(id);
    }

    @Override
    public List<LoanAccount> getLoansByCustomerId(Long customerId) {
        return loanAccountRepository.findByCustomerId(customerId);
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
