package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.entity.Account;
import com.we8techi.platform.finance.objects.APIResponse;

import java.util.List;

public interface AccountService {

    Account createAccount(Account account);

    List<Account> getAllAccounts(Long companyId);

    Account getAccount(Long account_id);

    Account updateAccount(Long account_id,Account account);

    APIResponse deleteAccount(Long account_id);
}
