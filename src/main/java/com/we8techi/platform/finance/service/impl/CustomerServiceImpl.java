package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.Customer;
import com.we8techi.platform.finance.mapper.CustomerMapper;
import com.we8techi.platform.finance.objects.CustomerDTO;
import com.we8techi.platform.finance.repository.CustomerRepository;
import com.we8techi.platform.finance.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> getAllCustomer() {
        log.info("Get All customers..!!!");
        List<Customer> customerList = customerRepository.findAll();
        return CustomerMapper.INSTANCE.mapToCustomerDTOList(customerList);
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        log.info("Save customer..!!!");
        Customer customer = customerRepository.save(CustomerMapper.INSTANCE.mapToCustomer(customerDTO));
        return CustomerMapper.INSTANCE.mapCustomerDto(customer);
    }
}
