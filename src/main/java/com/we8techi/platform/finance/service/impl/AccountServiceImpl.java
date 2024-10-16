package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.Account;
import com.we8techi.platform.finance.exception.ApplicationException;
import com.we8techi.platform.finance.exception.ResourceNotFoundException;
import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.repository.AccountRepository;
import com.we8techi.platform.finance.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;
    
    @Override
    public Account createAccount(Account account) {
        log.info("Adding Account..");
        return accountRepository.save(account);
    }


    @Override
    public Account getAccount(Long account_id) {
        return accountRepository.findById(account_id)
                .orElseThrow(() -> new ResourceNotFoundException("Account is not available for given id"));
    }

    @Override
    public List<Account> getAllAccountsForCustomer(Long companyId,Long customer_id) {
        log.info("Fetching all active accounts for a customer.."+customer_id);
        List<Account> accList = accountRepository.findAllAccountsForCust(companyId,customer_id);
        return accList.stream().filter(acc -> acc.getActive()).collect(Collectors.toList());
    }

    @Override
    public Account updateAccount(Long account_id,Account account) {
        Optional<Account> result = accountRepository.findById(account_id);

        if (result.isPresent()) {
            log.info("Account updating...");
            return accountRepository.save(account);
        } else {
            log.error("Invalid account details.");
            throw new ApplicationException("Invalid account details.", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public APIResponse deleteAccount(Long account_id) {
        Optional<Account> result = accountRepository.findById(account_id);
        if (result.isPresent()) {
            accountRepository.deleteById(account_id);
            log.info("Account deleted successfully.");
        } else {
            log.error("Invalid account details.");
            throw new ApplicationException("Invalid account details.", HttpStatus.BAD_REQUEST);
        }
        return APIResponse.builder().message("account details deleted successfully.").status(HttpStatus.OK).build();

    }
}
