package com.we8techi.platform.finance.repository;

import com.we8techi.platform.finance.entity.PigmiTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PigmiTransactionsRepository extends JpaRepository<PigmiTransactions, Long> {
    List<PigmiTransactions> getPigmiTransactionsByPigmiAccountId(Long pigmiAccountId);
    @Query(value = "select * from financedb.pigmi_transaction pt where pt.pigmi_account_id in (select pa.id  from financedb.pigmi_account pa where pa.customer_id = :customerId)" ,nativeQuery = true)
    List<PigmiTransactions> getPigmiTransactionsByCustmoerId(Long customerId);
}