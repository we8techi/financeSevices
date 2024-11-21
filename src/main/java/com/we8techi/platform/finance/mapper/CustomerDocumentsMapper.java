package com.we8techi.platform.finance.mapper;

import com.we8techi.platform.finance.entity.CustomerDocuments;
import com.we8techi.platform.finance.objects.CustomerDocumentsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.List;

/**
 * @author dhijadhav
 */

@Mapper(componentModel = "spring", imports = {LocalDate.class})
public interface CustomerDocumentsMapper {

    CustomerDocumentsMapper INSTANCE = Mappers.getMapper(CustomerDocumentsMapper.class);

    CustomerDocuments mapToCustomerDocuments(CustomerDocumentsDTO customerDocumentsDTO);

    List<CustomerDocumentsDTO> mapToCustomerDocumentsDTO(List<CustomerDocuments> customerDocumentsList);
}
