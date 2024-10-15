package com.we8techi.platform.finance.repository;

import com.we8techi.platform.finance.entity.Account;
import com.we8techi.platform.finance.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {

    @Query("FROM Account where  customerId = :customerId and active = true")
    List<Account> findAllAccountsForCust(@Param("customerId") Long customerId);

}
