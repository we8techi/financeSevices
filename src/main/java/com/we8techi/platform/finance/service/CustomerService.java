package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.CustomerDTO;

import java.util.List;

public interface CustomerService {
    /**
     * Get all types of customers for a company
     * @param companyId
     * @return list of customers
     */
    List<CustomerDTO> getAllCustomerForCompany(Long companyId);

    /**
     * Get customer details for a company
     * @param companyId
     * @param customerId
     * @return
     */
    CustomerDTO getCustomerDetails(Long companyId, Long customerId);

    /**
     * Save the customer for a company
     * @param companyId
     * @param customerDTO
     * @return
     */
    CustomerDTO saveCustomer(Long companyId, CustomerDTO customerDTO);

    /**
     * update the customer for a company
     * @param companyId
     * @param customerDTO
     * @return
     */
    CustomerDTO updateCustomer(Long companyId, CustomerDTO customerDTO);

    /**
     * Delete customer details by customerId for a company
     * @param companyId
     * @param customerId
     * @return
     */
    APIResponse deleteCustomerDetails(Long companyId, Long customerId);
}
