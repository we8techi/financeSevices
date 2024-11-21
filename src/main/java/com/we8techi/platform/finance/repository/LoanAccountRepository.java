package com.we8techi.platform.finance.repository;

import com.we8techi.platform.finance.entity.LoanAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanAccountRepository extends JpaRepository<LoanAccount, Long> {
    List<LoanAccount> findByCustomerId(Long customerId);

    Optional<LoanAccount> getLoanAccountById(Long id);

}