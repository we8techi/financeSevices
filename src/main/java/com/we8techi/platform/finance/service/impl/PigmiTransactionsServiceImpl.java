package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.PigmiTransactions;
import com.we8techi.platform.finance.mapper.PigmiTransactionsMapper;
import com.we8techi.platform.finance.objects.PigmiTransactionsDTO;
import com.we8techi.platform.finance.repository.PigmiTransactionsRepository;
import com.we8techi.platform.finance.service.PigmiTransactionsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PigmiTransactionsServiceImpl implements PigmiTransactionsService {
    private final PigmiTransactionsRepository pigmiTransactionsRepository;

    public PigmiTransactionsServiceImpl(PigmiTransactionsRepository pigmiTransactionsRepository) {
        this.pigmiTransactionsRepository = pigmiTransactionsRepository;
    }

    @Override
    public PigmiTransactionsDTO createPigmiTransactions(PigmiTransactionsDTO pigmiTransactionsDTO) {
        return PigmiTransactionsMapper.INSTANCE.toDto(
                pigmiTransactionsRepository.save(
                    PigmiTransactionsMapper.INSTANCE.toEntity(pigmiTransactionsDTO)
                )
        );
    }

    @Override
    public PigmiTransactionsDTO updatePigmiTransactions(Long id, PigmiTransactionsDTO updatedpigmiTransaction) {
        PigmiTransactions existingPigmiTransaction = pigmiTransactionsRepository.findById(id).orElse(null);
        if (existingPigmiTransaction != null) {
            return PigmiTransactionsMapper.INSTANCE.toDto(
                    pigmiTransactionsRepository.save(PigmiTransactionsMapper.INSTANCE.toEntity(updatedpigmiTransaction))
            );
        }
        return null;
    }

    @Override
    public void deletePigmiTransactions(Long id) {
        pigmiTransactionsRepository.deleteById(id);
    }

    @Override
    public List<PigmiTransactionsDTO> getAllPigmiTransactionsdByAccountId(Long id) {
        return PigmiTransactionsMapper.INSTANCE.toDtoList(
                pigmiTransactionsRepository.getPigmiTransactionsByPigmiAccountId(id)
        );
    }

    @Override
    public List<PigmiTransactionsDTO> getPigmiTransactionsByCustomerId(Long customerID) {
        return PigmiTransactionsMapper.INSTANCE.toDtoList(
                pigmiTransactionsRepository.getPigmiTransactionsByCustmoerId(customerID)
        );
    }
}
