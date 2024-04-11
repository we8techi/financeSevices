package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.Customer;
import com.we8techi.platform.finance.entity.CustomerDocuments;
import com.we8techi.platform.finance.exception.ApplicationException;
import com.we8techi.platform.finance.mapper.CustomerDocumentsMapper;
import com.we8techi.platform.finance.mapper.CustomerMapper;
import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.CustomerDTO;
import com.we8techi.platform.finance.objects.CustomerDocumentsDTO;
import com.we8techi.platform.finance.repository.CustomerDocumentsRepository;
import com.we8techi.platform.finance.repository.CustomerRepository;
import com.we8techi.platform.finance.service.CustomerService;
import com.we8techi.platform.finance.utils.Constants;
import com.we8techi.platform.finance.utils.CustomerFileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDocumentsRepository customerDocumentsRepository;

    @Override
    public List<CustomerDTO> getAllCustomerForCompany(Long companyId) {
        log.info("Get All active customers for a companyId={}", companyId);
        List<Customer> customerList = customerRepository.findAllCustomersForCompany(companyId);
        customerList = customerList.stream().filter(rec -> rec.getActive()).collect(Collectors.toList());
        return CustomerMapper.INSTANCE.mapToCustomerDTOList(customerList);
    }

    @Override
    public CustomerDTO getCustomerDetails(Long companyId, Long customerId) {
        log.info("Get customers details for a companyId={} and customerId={}", companyId, customerId);
        Optional<Customer> customerOptional = customerRepository.getCustomerByCompIdAndCustId(companyId, customerId);
        if(customerOptional.isPresent()) {
            return CustomerMapper.INSTANCE.mapCustomerDto(customerOptional.get());
        }
        throw new ApplicationException("Invalid customer details !!! ", HttpStatus.BAD_REQUEST);
    }

    @Override
    public CustomerDTO saveCustomer(Long companyId, CustomerDTO customerDTO) {
        log.info("Save customer for a companyId={}", companyId);
        Customer customer = customerRepository.save(CustomerMapper.INSTANCE.mapToCustomer(customerDTO));
        log.info("Customer saved successfully.");
        return CustomerMapper.INSTANCE.mapCustomerDto(customer);
    }

    @Override
    public CustomerDTO updateCustomer(Long companyId, CustomerDTO customerDTO) {
        log.info("Update customer for a companyId={}", companyId);
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
    public APIResponse deleteCustomerDetails(Long companyId, Long customerId) {
        log.info("Delete customers details for a companyId={}", companyId);
        Optional<Customer> customerOptional = customerRepository.getCustomerByCompIdAndCustId(companyId, customerId);
        if(customerOptional.isPresent()) {
            customerRepository.deleteCustomerDetails(customerId);
            return new APIResponse("Customer deleted successfully", HttpStatus.OK);
        }
        throw new ApplicationException("Invalid customer details !!! ", HttpStatus.BAD_REQUEST);
    }

    @Override
    @Transactional
    public void uploadCustomerDocuments(Long companyId, Long customerId, MultipartFile file, CustomerDocumentsDTO customerDocumentsDTO) throws IOException {
        log.info("Upload customer document for a customerId ={}", customerId);
        try{
            String documentName = StringUtils.cleanPath(file.getOriginalFilename());
            customerDocumentsDTO.setCustomerId(customerId);
            customerDocumentsDTO.setDocumentName(documentName.split(Constants.DOCUMENT_NAME_SEPARATOR)[0]);
            customerDocumentsDTO.setFile(CustomerFileUtils.encodedBase64String(file).getBytes());
            customerDocumentsDTO.setDocumentSize(file.getSize());
            customerDocumentsDTO.setDocumentExtension(documentName.split(Constants.DOCUMENT_NAME_SEPARATOR)[1].toLowerCase());

            CustomerDocuments customerDocuments = CustomerDocumentsMapper.INSTANCE.mapToCustomerDocuments(customerDocumentsDTO);
            customerDocumentsRepository.save(customerDocuments);
            log.info("Document uploaded successfully...!!!");

        } catch (Exception ex){
            log.error("Exception occurred while customer document upload with message ={}", ex.getMessage());
            throw new ApplicationException("Exception occurred while customer document upload", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
