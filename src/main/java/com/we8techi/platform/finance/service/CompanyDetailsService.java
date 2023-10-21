package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.CompanyDetailsDTO;

import java.util.List;

/**
 * @author dhijadhav
 */

public interface CompanyDetailsService {

    /**
     * Get all company details
     *
     * @return all company details
     */
    List<CompanyDetailsDTO> getAllCompaniesDetails();

    /**
     * Save new company details
     *
     * @param companyDetailsDTOList
     * @return saved company details
     */
    List<CompanyDetailsDTO> saveAllCompanies(List<CompanyDetailsDTO> companyDetailsDTOList);


    /**
     * Update existing company details
     * @param companyDetailsDTOList
     * @return updated company details
     */
    List<CompanyDetailsDTO> updateAllCompanies(List<CompanyDetailsDTO> companyDetailsDTOList);


    /**
     * Delete company details
     * @param companyId
     * @return
     */
    APIResponse deleteCompanyDetails(Long companyId);
}
