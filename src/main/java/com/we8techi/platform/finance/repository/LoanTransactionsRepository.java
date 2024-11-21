package com.we8techi.platform.finance.repository;

import com.we8techi.platform.finance.entity.LoanTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LoanTransactionsRepository extends JpaRepository<LoanTransactions, Long> {
    List<LoanTransactions> findByLoanAccountId(Long loanAccountId);

}