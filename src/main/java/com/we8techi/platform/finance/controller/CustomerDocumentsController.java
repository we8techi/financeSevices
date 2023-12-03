package com.we8techi.platform.finance.controller;

import com.we8techi.platform.finance.entity.CustomerDocuments;
import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.CustomerDocumentsDTO;
import com.we8techi.platform.finance.service.CustomerDocumentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/{companyId}")
@PreAuthorize("isAuthenticated() and " + "hasAnyAuthority('ADMIN','USER')")
public class CustomerDocumentsController {

    private final CustomerDocumentsService customerDocumentsService;

    @PostMapping("/documents/{customerId}")
    public ResponseEntity<APIResponse> uploadCustomerDocuments(@PathVariable("customerId") Long customerId, @RequestPart CustomerDocumentsDTO customerDocumentsDTO, @RequestParam("file") MultipartFile file) {
        log.info("Inside Customer document upload controller...!!!");

        APIResponse apiResponse = customerDocumentsService.uploadCustomerDocument(customerId, customerDocumentsDTO, file);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/documents/{customerId}/{documentType}")
    public ResponseEntity<byte[]> getCustomerDocumentsFileWithType(@PathVariable("customerId") Long customerId, @PathVariable("documentType") String documentType) {

        Optional<CustomerDocuments> customerDocuments = customerDocumentsService.getCustomerDocuments(customerId, documentType);

        CustomerDocuments custDoc = customerDocuments.get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + custDoc.getDocumentName() + "\"")
                .body(custDoc.getFile());

    }
}
