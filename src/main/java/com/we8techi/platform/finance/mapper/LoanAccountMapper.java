package com.we8techi.platform.finance.mapper;

import com.we8techi.platform.finance.entity.LoanAccount;
import com.we8techi.platform.finance.objects.LoanAccountDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoanAccountMapper {


    LoanAccountDTO toDto(LoanAccount entity);

    LoanAccount toEntity(LoanAccountDTO dto);

    List<LoanAccountDTO> toDtoList(List<LoanAccount> entityList);

    List<LoanAccount> toEntityList(List<LoanAccountDTO> dtoList);
}
