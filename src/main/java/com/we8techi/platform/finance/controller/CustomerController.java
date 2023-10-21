package com.we8techi.platform.finance.controller;

import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.CustomerDTO;
import com.we8techi.platform.finance.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@PreAuthorize("isAuthenticated() and " + "hasAnyAuthority('ADMIN','USER')")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        log.info("Fetch all customer details method....");

        List<CustomerDTO> customerDTOList = customerService.getAllCustomer();

        return new ResponseEntity<>(customerDTOList, HttpStatus.OK);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerDetails(@PathVariable("customerId") Long customerId) {
        log.info("Fetch customer details by customerId method....");

        CustomerDTO customerDTO = customerService.getCustomerDetails(customerId);

        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }


    @PostMapping("/customers")
    public ResponseEntity<CustomerDTO> saveCustomerDetails(@RequestBody CustomerDTO customerDTO) {
        log.info("Inside Customer controller method to create a customer .......");

        CustomerDTO resultDTO = customerService.saveCustomer(customerDTO);

        return new ResponseEntity<>(resultDTO, HttpStatus.CREATED);
    }

    @PutMapping("/customers")
    public ResponseEntity<CustomerDTO> updateCustomerDetails(@RequestBody CustomerDTO customerDTO) {
        log.info("Inside Customer controller method to update a customer details .......");

        CustomerDTO resultDTO = customerService.updateCustomer(customerDTO);

        return new ResponseEntity<>(resultDTO, HttpStatus.OK);
    }


    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<APIResponse> deleteCustomerDetails(@PathVariable("customerId") Long customerId) {
        log.info("Delete customer details by customerId method....");

        APIResponse apiResponse = customerService.deleteCustomerDetails(customerId);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
