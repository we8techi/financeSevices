package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.LoanTransactions;
import com.we8techi.platform.finance.mapper.LoanTransactionsMapper;
import com.we8techi.platform.finance.objects.LoanTransactionsDTO;
import com.we8techi.platform.finance.repository.LoanTransactionsRepository;
import com.we8techi.platform.finance.service.LoanTransactionsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoanTransactionsServiceImpl implements LoanTransactionsService {
    private final LoanTransactionsRepository loanTransactionRepository;

    public LoanTransactionsServiceImpl(LoanTransactionsRepository loanTransactionRepository) {
        this.loanTransactionRepository = loanTransactionRepository;
    }

    public LoanTransactionsDTO createLoanTransaction(LoanTransactionsDTO loanTransactionsDTO) {
        return LoanTransactionsMapper.INSTANCE.toDto(
                loanTransactionRepository.save(LoanTransactionsMapper.INSTANCE.toEntity(loanTransactionsDTO))
        );

    }

    public LoanTransactionsDTO getLoanTransactionById(Long id) {
        return LoanTransactionsMapper.INSTANCE.toDto(
                loanTransactionRepository.findById(id).orElse(null)
        );
    }

    public List<LoanTransactionsDTO> getAllLoanTransactions() {
        return LoanTransactionsMapper.INSTANCE.toDtoList(
                loanTransactionRepository.findAll()
                );
    }

    public LoanTransactionsDTO updateLoanTransaction(Long id, LoanTransactionsDTO updatedLoanTransaction) {
        LoanTransactions existingLoanTransaction = loanTransactionRepository.findById(id).orElse(null);
        if (existingLoanTransaction != null) {
            return LoanTransactionsMapper.INSTANCE.toDto(
                    loanTransactionRepository.save(LoanTransactionsMapper.INSTANCE.toEntity(updatedLoanTransaction))
            );
        }
        return null;
    }

    public void deleteLoanTransaction(Long id) {
        loanTransactionRepository.deleteById(id);
    }

    @Override
    public List<LoanTransactionsDTO> getLoanTransactionsByLoanAccountId(Long loanAccountId) {
        return LoanTransactionsMapper.INSTANCE.toDtoList(
                loanTransactionRepository.findByLoanAccountId(loanAccountId)
        );
    }

}
