package com.we8techi.platform.finance.mapper;


import com.we8techi.platform.finance.entity.CustomerDocuments;
import com.we8techi.platform.finance.objects.CustomerDocumentsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

/**
 * @author dhijadhav
 */

@Mapper(componentModel = "spring", imports = {LocalDate.class})
public interface CustomerDocumentsMapper {

    CustomerDocumentsMapper INSTANCE = Mappers.getMapper(CustomerDocumentsMapper.class);

    CustomerDocuments mapToCustomerDocuments(CustomerDocumentsDTO customerDocumentsDTO);
}
