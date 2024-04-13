package com.we8techi.platform.finance.mapper;

import com.we8techi.platform.finance.entity.LoanAccount;
import com.we8techi.platform.finance.entity.LoanTransactions;
import com.we8techi.platform.finance.entity.PigmiAccount;
import com.we8techi.platform.finance.objects.LoanAccountDTO;
import com.we8techi.platform.finance.objects.LoanTransactionsDTO;
import com.we8techi.platform.finance.objects.PigmiAccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoanAccountMapper {


    LoanAccountDTO toDto(LoanAccount entity);

    LoanAccount toEntity(LoanAccountDTO dto);

    List<LoanAccountDTO> toDtoList(List<LoanAccount> entityList);

    List<LoanAccount> toEntityList(List<LoanAccountDTO> dtoList);
}


