package com.we8techi.platform.finance.controller;

import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.CustomerDTO;
import com.we8techi.platform.finance.objects.CustomerDocumentsDTO;
import com.we8techi.platform.finance.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/{companyId}")
@PreAuthorize("isAuthenticated() and " + "hasAnyAuthority('ADMIN','USER', 'SUPER_ADMIN')")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(@PathVariable("companyId") Long companyId) {
        log.info("Fetch all customer details for a companyId={} ", companyId);

        List<CustomerDTO> customerDTOList = customerService.getAllCustomerForCompany(companyId);

        return new ResponseEntity<>(customerDTOList, HttpStatus.OK);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerDetails(@PathVariable("companyId") Long companyId, @PathVariable("customerId") Long customerId) {
        log.info("Fetch customer details by customerId method....");

        CustomerDTO customerDTO = customerService.getCustomerDetails(companyId, customerId);

        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }


    @PostMapping("/customers")
    public ResponseEntity<CustomerDTO> saveCustomerDetails(@PathVariable("companyId") Long companyId, @RequestBody CustomerDTO customerDTO) {
        log.info("Inside Customer controller method to create a customer .......");

        CustomerDTO resultDTO = customerService.saveCustomer(companyId, customerDTO);

        return new ResponseEntity<>(resultDTO, HttpStatus.CREATED);
    }

    @PutMapping("/customers")
    public ResponseEntity<CustomerDTO> updateCustomerDetails(@PathVariable("companyId") Long companyId, @RequestBody CustomerDTO customerDTO) {
        log.info("Inside Customer controller method to update a customer details .......");

        CustomerDTO resultDTO = customerService.updateCustomer(companyId, customerDTO);

        return new ResponseEntity<>(resultDTO, HttpStatus.OK);
    }


    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<APIResponse> deleteCustomerDetails(@PathVariable("companyId") Long companyId, @PathVariable("customerId") Long customerId) {
        log.info("Delete customer details by customerId method....");

        APIResponse apiResponse = customerService.deleteCustomerDetails(companyId, customerId);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/customers/{customerId}/documents", headers = "Accept=application/json", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<APIResponse> uploadCustomerDocument(@PathVariable("companyId") Long companyId,
                                                              @PathVariable("customerId") Long customerId,
                                                              @RequestPart CustomerDocumentsDTO customerDocumentsDTO,
                                                              @RequestPart("file") MultipartFile file) throws IOException {

        log.info("Document uploaded for a customer id ={} and type ={}", customerId, customerDocumentsDTO.getDocumentType());
        customerService.uploadCustomerDocuments(companyId, customerId, file, customerDocumentsDTO);
        return new ResponseEntity<>(
                APIResponse
                        .builder()
                        .message(String.format("Customer document uploaded successfully: %s", file.getOriginalFilename()))
                        .status(HttpStatus.OK).build(), HttpStatus.OK);
    }


    @GetMapping("/customers/{customerId}/documents")
    public ResponseEntity<List<CustomerDocumentsDTO>> retrieveCustomerDocumentsByCustId(@PathVariable("companyId") Long companyId, @PathVariable("customerId") Long customerId) {

        log.info("Retrieve customer documents for a company id ={} and customer id ={}", companyId, customerId);

        List<CustomerDocumentsDTO> customerDocumentsDTOList = customerService.retrieveCustomerDocumentsByCustId(customerId);
        return new ResponseEntity<>(customerDocumentsDTOList, HttpStatus.OK);
    }

    @GetMapping("/customers/documents")
    public ResponseEntity<List<CustomerDocumentsDTO>> retrieveCustomerDocumentsByCompanyId(@PathVariable("companyId") Long companyId, @RequestParam("documentType") String documentType) {

        log.info("Retrieve customer documents for a company id ={} and documentType ={}", companyId, documentType);

        List<CustomerDocumentsDTO> customerDocumentsDTOList = customerService.retrieveCustDocumentsByCompanyIdAndType(companyId, documentType);
        return new ResponseEntity<>(customerDocumentsDTOList, HttpStatus.OK);
    }
}
