package com.we8techi.platform.finance.mapper;

import com.we8techi.platform.finance.entity.Expense;
import com.we8techi.platform.finance.objects.ExpenseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);

    ExpenseDTO toDto(Expense expense);

    Expense toEntity(ExpenseDTO expenseDTO);
}
