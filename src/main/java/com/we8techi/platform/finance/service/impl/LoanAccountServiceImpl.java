package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.LoanAccount;
import com.we8techi.platform.finance.exception.ApplicationException;
import com.we8techi.platform.finance.mapper.LoanAccountMapperFactory;
import com.we8techi.platform.finance.objects.LoanAccountDTO;
import com.we8techi.platform.finance.objects.LoanCalRequest;
import com.we8techi.platform.finance.objects.LoanCalResponse;
import com.we8techi.platform.finance.repository.LoanAccountRepository;
import com.we8techi.platform.finance.service.LoanAccountService;
import com.we8techi.platform.finance.utils.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
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

        Optional<LoanAccount> optionalLoanAccount = loanAccountRepository.getLoanAccountById(id);
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
    public LoanCalResponse calculateLoanAmount(LoanCalRequest loanCalRequest) {
        log.info("Inside the calculate Loan Method ...!!!");
        LoanCalResponse loanCalResponse=null;
        Double passbookCharge=0.0;
        LocalDate collectionStartDate=null;
        Double issueAmount=0.0;
        Double perDayEmi=0.0;
        Double finalIssueAmount=0.0;

        try {
            Double perDayInterest=AppUtils.round((AppUtils.percent(loanCalRequest.getPrincipleAmount(),2) *loanCalRequest.getInterestRate())/30,2);
            Double thirtyDaysInterest = AppUtils.round(perDayInterest*30,2);
            Double hundredDaysInterest = AppUtils.round(perDayInterest*100,2);


            if(loanCalRequest.getPassbookCharges()!=null && loanCalRequest.getPassbookCharges()>0){
                passbookCharge= loanCalRequest.getPassbookCharges();
            }
            Instant instant = Instant.parse(loanCalRequest.getDisbursementDate());
            LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

            if(loanCalRequest.getLoanType().equals("D")){
                collectionStartDate  = localDate.plusDays(1);
                issueAmount = AppUtils.round((loanCalRequest.getPrincipleAmount()),2)-passbookCharge;
                loanCalResponse= new LoanCalResponse(collectionStartDate,perDayInterest,thirtyDaysInterest,issueAmount,passbookCharge,collectionStartDate,"D",loanCalRequest.getPrincipleAmount()+perDayInterest,perDayInterest,0.0);
            }else if(loanCalRequest.getLoanType().equals("M")){
                collectionStartDate  = localDate.plusDays(30);
                issueAmount = AppUtils.round((loanCalRequest.getPrincipleAmount()),2)-passbookCharge;
                loanCalResponse= new LoanCalResponse(collectionStartDate,perDayInterest,thirtyDaysInterest,issueAmount,passbookCharge,collectionStartDate,"M",loanCalRequest.getPrincipleAmount()+thirtyDaysInterest,0.0,thirtyDaysInterest);
            }else{
                collectionStartDate  = localDate.plusDays(1);
                issueAmount = AppUtils.round((loanCalRequest.getPrincipleAmount()),2);
                perDayEmi = AppUtils.round(issueAmount/100,2);
                finalIssueAmount=(issueAmount-hundredDaysInterest)-passbookCharge;
                loanCalResponse= new LoanCalResponse(collectionStartDate,perDayInterest,thirtyDaysInterest,finalIssueAmount,passbookCharge,collectionStartDate,"M",loanCalRequest.getPrincipleAmount()+thirtyDaysInterest,perDayEmi,0.0);
            }
            return loanCalResponse;
        } catch (Exception ex) {
            log.error("Exception Occurred while loan amount calculation error ={}", ex.getMessage());
            throw new ApplicationException("Exception Occurred while loan amount calculation.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
