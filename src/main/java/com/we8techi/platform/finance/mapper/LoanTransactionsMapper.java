package com.we8techi.platform.finance.mapper;

import com.we8techi.platform.finance.entity.LoanTransactions;
import com.we8techi.platform.finance.objects.LoanTransactionsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoanTransactionsMapper {
    public static final LoanTransactionsMapper INSTANCE = Mappers.getMapper(LoanTransactionsMapper.class);

    LoanTransactionsDTO toDto(LoanTransactions entity);

    LoanTransactions toEntity(LoanTransactionsDTO dto);

    List<LoanTransactionsDTO> toDtoList(List<LoanTransactions> entityList);

    List<LoanTransactions> toEntityList(List<LoanTransactionsDTO> dtoList);
}
