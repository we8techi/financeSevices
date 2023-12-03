package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.entity.CustomerDocuments;
import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.CustomerDocumentsDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface CustomerDocumentsService {

    /**
     * @param customerId
     * Upload customer document.
     * @param customerDocumentsDTO
     * @param file
     * @return APIResponse
     */
    APIResponse uploadCustomerDocument(Long customerId, CustomerDocumentsDTO customerDocumentsDTO, MultipartFile file);

    /**
     * Fetch customer document based on customerId and documentType
     * @param customerId
     * @param documentType
     * @return CustomerDocuments
     */
    Optional<CustomerDocuments> getCustomerDocuments(Long customerId, String documentType);
}
