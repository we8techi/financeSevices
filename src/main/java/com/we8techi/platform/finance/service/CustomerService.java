package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.CustomerDTO;
import com.we8techi.platform.finance.objects.CustomerDocumentsDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    /**
     * Upload customer document.
     * @param companyId
     * @param customerId
     * @param file
     * @param customerDocumentsDTO
     */
    void uploadCustomerDocuments(Long companyId, Long customerId, MultipartFile file, CustomerDocumentsDTO customerDocumentsDTO) throws IOException;

    /**
     * Retrieve Customer specific documents
     * @param customerId
     * @return
     */
    List<CustomerDocumentsDTO> retrieveCustomerDocumentsByCustId(Long customerId);


    /**
     * Retrieve customer documents by company id and document type
     * @param companyId
     * @param documentType
     * @return
     */
    List<CustomerDocumentsDTO> retrieveCustDocumentsByCompanyIdAndType(Long companyId, String documentType);
}
