package com.we8techi.platform.finance.controller;

import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.CompanyDetailsDTO;
import com.we8techi.platform.finance.service.CompanyDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dhijadhav
 */

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@PreAuthorize("isAuthenticated() and " + "hasAuthority('SUPER_ADMIN')")
public class CompanyDetailsController {

    private final CompanyDetailsService companyDetailsService;

    @GetMapping("/companies")
    public ResponseEntity<List<CompanyDetailsDTO>> getAllCompanyDetails() {
        log.info("Fetch all company details method....");

        List<CompanyDetailsDTO> companyDetailsDTOList = companyDetailsService.getAllCompaniesDetails();

        return new ResponseEntity<>(companyDetailsDTOList, HttpStatus.OK);
    }

    @PostMapping("/company/registration")
    public ResponseEntity<List<CompanyDetailsDTO>> registerCompanyDetailsList(@RequestBody List<CompanyDetailsDTO> companyDetailsDTOList) {
        log.info("Inside Company Registration controller method .......");

        List<CompanyDetailsDTO> companyDetailsDTOS = companyDetailsService.saveAllCompanies(companyDetailsDTOList);

        return new ResponseEntity<>(companyDetailsDTOS, HttpStatus.CREATED);
    }

    @PutMapping("/company/details")
    public ResponseEntity<List<CompanyDetailsDTO>> updateCompanyDetails(@RequestBody List<CompanyDetailsDTO> companyDetailsDTOList) {
        log.info("Inside Company update controller method .....");

        List<CompanyDetailsDTO> companyDetailsDTOS = companyDetailsService.updateAllCompanies(companyDetailsDTOList);

        return new ResponseEntity<>(companyDetailsDTOS, HttpStatus.OK);
    }

    @DeleteMapping("/company/{companyId}")
    public ResponseEntity<APIResponse> deleteCompanyDetails(@PathVariable("companyId") Long companyId) {
        log.info("Inside Company delete controller method.....");

        APIResponse result = companyDetailsService.deleteCompanyDetails(companyId);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
