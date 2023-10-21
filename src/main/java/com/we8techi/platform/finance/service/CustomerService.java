package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.CustomerDTO;

import java.util.List;

public interface CustomerService {
    /**
     * Get all types of customers
     * @return
     */
    List<CustomerDTO> getAllCustomer();

    /**
     * Get customer details
     * @param customerId
     * @return
     */
    CustomerDTO getCustomerDetails(Long customerId);

    /**
     * Save the customer
     * @param customerDTO
     * @return CustomerDTO
     */
    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    /**
     * update the customer
     * @param customerDTO
     * @return CustomerDTO
     */
    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    /**
     * Delete customer details by customerId
     * @param customerId
     * @return
     */
    APIResponse deleteCustomerDetails(Long customerId);
}
