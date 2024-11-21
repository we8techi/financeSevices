package com.we8techi.platform.finance.mapper;

import com.we8techi.platform.finance.entity.PigmiAccount;
import com.we8techi.platform.finance.objects.PigmiAccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PigmiAccountMapper {

    PigmiAccountMapper INSTANCE = Mappers.getMapper(PigmiAccountMapper.class);
    PigmiAccountDTO toDto(PigmiAccount entity);

    PigmiAccount toEntity(PigmiAccountDTO dto);

    List<PigmiAccountDTO> toDtoList(List<PigmiAccount> entityList);

    List<PigmiAccount> toEntityList(List<PigmiAccountDTO> dtoList);
}

