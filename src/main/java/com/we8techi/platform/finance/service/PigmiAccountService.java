package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.objects.PigmiAccountDTO;
import java.util.List;

public interface PigmiAccountService {
    PigmiAccountDTO createPigmiAccount(PigmiAccountDTO loanTransaction);

    PigmiAccountDTO getPigmiAccountById(Long id);

    List<PigmiAccountDTO> getAllPigmiAccount();

    PigmiAccountDTO updatePigmiAccount(Long id, PigmiAccountDTO updatedLoanTransaction);

    void deletePigmiAccount(Long id);

    List<PigmiAccountDTO> getPigmiAccountByCustomerId(Long loanAccountId);

}

