package com.we8techi.platform.finance.repository;

import com.we8techi.platform.finance.entity.PigmiAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PigmiAccountRepository extends JpaRepository<PigmiAccount, Long> {

    List<PigmiAccount> getPigmiAccountByCustomerId(Long customerId);
}