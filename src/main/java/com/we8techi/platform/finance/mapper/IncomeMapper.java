package com.we8techi.platform.finance.mapper;

import com.we8techi.platform.finance.entity.Income;
import com.we8techi.platform.finance.objects.IncomeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IncomeMapper {

    IncomeMapper INSTANCE = Mappers.getMapper(IncomeMapper.class);

    IncomeDTO toDto(Income income);

    Income toEntity(IncomeDTO incomeDTO);
}

