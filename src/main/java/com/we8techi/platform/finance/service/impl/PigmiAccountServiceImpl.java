package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.PigmiAccount;
import com.we8techi.platform.finance.mapper.PigmiAccountMapper;
import com.we8techi.platform.finance.objects.PigmiAccountDTO;
import com.we8techi.platform.finance.repository.PigmiAccountRepository;
import com.we8techi.platform.finance.service.PigmiAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PigmiAccountServiceImpl implements PigmiAccountService {

    private final PigmiAccountRepository pigmiAccountRepository;

    public PigmiAccountServiceImpl(PigmiAccountRepository pigmiAccountRepository) {
        this.pigmiAccountRepository = pigmiAccountRepository;
    }

    @Override
    public PigmiAccountDTO createPigmiAccount(PigmiAccountDTO pigmiAccountDTO) {
        return PigmiAccountMapper.INSTANCE.toDto(
                    pigmiAccountRepository.save(PigmiAccountMapper.INSTANCE.toEntity(pigmiAccountDTO))
                );
    }

    @Override
    public PigmiAccountDTO getPigmiAccountById(Long id) {
        return PigmiAccountMapper.INSTANCE.toDto(
                pigmiAccountRepository.findById(id).orElse(null)
        );
    }

    @Override
    public List<PigmiAccountDTO> getAllPigmiAccount() {
        return PigmiAccountMapper.INSTANCE.toDtoList(
                pigmiAccountRepository.findAll()
        );
    }

    @Override
    public PigmiAccountDTO updatePigmiAccount(Long id, PigmiAccountDTO updatedPigmiAccountDTO) {
        Optional<PigmiAccount> optionalPigmiAccount = pigmiAccountRepository.findById(id);
        if (optionalPigmiAccount.isPresent()) {
            return PigmiAccountMapper.INSTANCE.toDto(
                    pigmiAccountRepository.save(
                            PigmiAccountMapper.INSTANCE.toEntity(updatedPigmiAccountDTO))
            );
        }
        return null;
    }

    @Override
    public void deletePigmiAccount(Long id) {
        pigmiAccountRepository.deleteById(id);

    }

    @Override
    public List<PigmiAccountDTO> getPigmiAccountByCustomerId(Long customerId) {
        return PigmiAccountMapper.INSTANCE.toDtoList( pigmiAccountRepository.getPigmiAccountByCustomerId(customerId)
        );
    }
}
