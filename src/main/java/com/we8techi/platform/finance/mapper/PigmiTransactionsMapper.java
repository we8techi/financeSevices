package com.we8techi.platform.finance.mapper;

import com.we8techi.platform.finance.entity.PigmiTransactions;
import com.we8techi.platform.finance.objects.PigmiTransactionsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PigmiTransactionsMapper {

    public static final PigmiTransactionsMapper INSTANCE = Mappers.getMapper(PigmiTransactionsMapper.class);

    PigmiTransactionsDTO toDto(PigmiTransactions entity);

    PigmiTransactions toEntity(PigmiTransactionsDTO dto);

    List<PigmiTransactionsDTO> toDtoList(List<PigmiTransactions> entityList);

    List<PigmiTransactions> toEntityList(List<PigmiTransactionsDTO> dtoList);
}
