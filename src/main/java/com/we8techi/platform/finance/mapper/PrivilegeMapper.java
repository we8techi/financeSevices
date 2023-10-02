package com.we8techi.platform.finance.mapper;

import com.we8techi.platform.finance.entity.Privilege;
import com.we8techi.platform.finance.objects.PrivilegeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring", imports = {LocalDate.class})
public interface PrivilegeMapper {

    PrivilegeMapper INSTANCE = Mappers.getMapper(PrivilegeMapper.class);

    List<PrivilegeDTO> mapToPrivilegeDtoList(List<Privilege> privilegeList);
}
