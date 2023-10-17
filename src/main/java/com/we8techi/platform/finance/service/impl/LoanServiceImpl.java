package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.exception.ApplicationException;
import com.we8techi.platform.finance.objects.LoanCalRequest;
import com.we8techi.platform.finance.service.LoanService;
import com.we8techi.platform.finance.utils.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author dhijadhav
 */

@Slf4j
@Service
public class LoanServiceImpl implements LoanService {

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
