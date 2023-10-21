package com.we8techi.platform.finance.mapper;

import com.we8techi.platform.finance.entity.Customer;
import com.we8techi.platform.finance.objects.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring", imports = {LocalDate.class})
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    List<CustomerDTO> mapToCustomerDTOList(List<Customer> customerList);

    Customer mapToCustomer(CustomerDTO customerDTO);

    CustomerDTO mapCustomerDto(Customer customer);
}
