package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.objects.CustomerDTO;

import java.util.List;

public interface CustomerService {
    /**
     * Get all types of customers
     * @return
     */
    List<CustomerDTO> getAllCustomer();

    /**
     * Save the customer
     * @param customerDTO
     * @return CustomerDTO
     */
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
}
