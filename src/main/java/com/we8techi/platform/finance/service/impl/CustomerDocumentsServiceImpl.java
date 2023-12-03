package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.CustomerDocuments;
import com.we8techi.platform.finance.exception.ApplicationException;
import com.we8techi.platform.finance.mapper.CustomerDocumentsMapper;
import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.CustomerDocumentsDTO;
import com.we8techi.platform.finance.repository.CustomerDocumentsRepository;
import com.we8techi.platform.finance.service.CustomerDocumentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;


/**
 * @author dhijadhav
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerDocumentsServiceImpl implements CustomerDocumentsService {


    private final CustomerDocumentsRepository customerDocumentsRepository;

    @Override
    public APIResponse uploadCustomerDocument(Long customerId, CustomerDocumentsDTO customerDocumentsDTO, MultipartFile file) {
        log.info("Customer document upload process started....!!!!");
        try {
            if (!file.isEmpty() && file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
                String fileName = file.getOriginalFilename();
                String fileExtension = fileName.split("\\.")[1].toLowerCase();
                customerDocumentsDTO.setDocumentName(fileName);
                customerDocumentsDTO.setDocumentExtension(fileExtension);
                customerDocumentsDTO.setDocumentSize(file.getSize());
                customerDocumentsDTO.setActive(true);
                customerDocumentsDTO.setFile(file.getBytes());

                CustomerDocuments customerDocuments = CustomerDocumentsMapper.INSTANCE.mapToCustomerDocuments(customerDocumentsDTO);

                customerDocumentsRepository.save(customerDocuments);

                log.info("Customer document uploaded successfully!!!");

            } else {
                throw new ApplicationException("Invalid uploaded document.", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            throw new ApplicationException("Exception Occurred while customer document upload.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return APIResponse.builder().message("Customer document uploaded successfully!!!").status(HttpStatus.OK).build();
    }

    @Override
    public Optional<CustomerDocuments> getCustomerDocuments(Long customerId, String documentType) {
        return customerDocumentsRepository.findByIdAndDocumentType(customerId,documentType);
    }
}
