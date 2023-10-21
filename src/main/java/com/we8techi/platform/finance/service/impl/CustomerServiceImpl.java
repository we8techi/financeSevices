package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.Customer;
import com.we8techi.platform.finance.exception.ApplicationException;
import com.we8techi.platform.finance.mapper.CustomerMapper;
import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.CustomerDTO;
import com.we8techi.platform.finance.repository.CustomerRepository;
import com.we8techi.platform.finance.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> getAllCustomer() {
        log.info("Get All active customers..!!!");
        List<Customer> customerList = customerRepository.findAll();
        customerList = customerList.stream().filter(rec -> rec.getActive()).collect(Collectors.toList());
        return CustomerMapper.INSTANCE.mapToCustomerDTOList(customerList);
    }

    @Override
    public CustomerDTO getCustomerDetails(Long customerId) {
        log.info("Get customers details..!!!");
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isPresent()) {
            return CustomerMapper.INSTANCE.mapCustomerDto(customerOptional.get());
        }
        throw new ApplicationException("Invalid customer details !!! ", HttpStatus.BAD_REQUEST);
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        log.info("Save customer..!!!");
        Customer customer = customerRepository.save(CustomerMapper.INSTANCE.mapToCustomer(customerDTO));
        return CustomerMapper.INSTANCE.mapCustomerDto(customer);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        log.info("Update customer..!!!");
        boolean isUpdatable = true;
        if(Objects.isNull(customerDTO.getId()) || Objects.isNull(customerDTO.getCompanyId()) ) {
            isUpdatable = false;
        }
        if(isUpdatable) {
            Optional<Customer> customerOptional = customerRepository.findById(customerDTO.getId());
            if(customerOptional.isPresent()) {
                Customer customer = CustomerMapper.INSTANCE.mapToCustomer(customerDTO);
                customerRepository.save(customer);
                log.info("Updated customer details successfully..!!!");
                return customerDTO;
            }
        }
        throw new ApplicationException("Invalid customer details !!! ", HttpStatus.BAD_REQUEST);
    }

    @Override
    @Transactional
    public APIResponse deleteCustomerDetails(Long customerId) {
        log.info("Delete customers details..!!!");
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isPresent()) {
            customerRepository.deleteCustomerDetails(customerId);
            return new APIResponse("Customer deleted successfully", HttpStatus.OK);
        }
        throw new ApplicationException("Invalid customer details !!! ", HttpStatus.BAD_REQUEST);
    }


}
