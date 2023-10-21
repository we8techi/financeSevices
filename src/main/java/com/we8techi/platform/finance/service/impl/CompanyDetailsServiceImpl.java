package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.CompanyDetails;
import com.we8techi.platform.finance.exception.ApplicationException;
import com.we8techi.platform.finance.mapper.CompanyDetailsMapper;
import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.CompanyDetailsDTO;
import com.we8techi.platform.finance.repository.CompanyDetailsRepository;
import com.we8techi.platform.finance.service.CompanyDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author dhijadhav
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class CompanyDetailsServiceImpl implements CompanyDetailsService {

    private final CompanyDetailsRepository companyDetailsRepository;

    @Override
    public List<CompanyDetailsDTO> getAllCompaniesDetails() {
        log.info("Get all company details ...!!!");
        List<CompanyDetails> companyDetailsList = null;
        try {
            companyDetailsList = companyDetailsRepository.findAll();
            log.info("Company details retrieved successfully...!!!");
        } catch (Exception ex) {
            log.error("Exception occurred while retrieving the company details...!!!");
            throw new ApplicationException("Exception occurred while retrieving the company details.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return !CollectionUtils.isEmpty(companyDetailsList) ? CompanyDetailsMapper.INSTANCE.mapToCompanyDetailsDtoList(companyDetailsList) : new ArrayList<>();
    }

    @Override
    public List<CompanyDetailsDTO> saveAllCompanies(List<CompanyDetailsDTO> companyDetailsDTOList) {
        log.info("Save company details ...!!!");
        List<CompanyDetails> companyDetailsList = null;
        try {
            companyDetailsList = CompanyDetailsMapper.INSTANCE.mapToCompanyDetailsList(companyDetailsDTOList);
            if (!CollectionUtils.isEmpty(companyDetailsList)) {
                companyDetailsList = companyDetailsRepository.saveAll(companyDetailsList);
            }
            log.info("Company details saved successfully...!!!");
        } catch (Exception ex) {
            log.error("Exception occurred while saving the company details...!!!");
            throw new ApplicationException("Exception occurred while saving the company details.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return !CollectionUtils.isEmpty(companyDetailsList) ? CompanyDetailsMapper.INSTANCE.mapToCompanyDetailsDtoList(companyDetailsList) : new ArrayList<>();
    }

    @Override
    public List<CompanyDetailsDTO> updateAllCompanies(List<CompanyDetailsDTO> companyDetailsDTOList) {
        log.info("Update the company details data");
        if (!CollectionUtils.isEmpty(companyDetailsDTOList)) {
            List<CompanyDetailsDTO> result = companyDetailsDTOList.stream().filter(cd -> Objects.isNull(cd.getId())).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(result)) {
                throw new ApplicationException("Invalid company details...!!!", HttpStatus.BAD_REQUEST);
            }
            try {
                List<CompanyDetails> companyDetailsList = CompanyDetailsMapper.INSTANCE.mapToCompanyDetailsList(companyDetailsDTOList);
                companyDetailsRepository.saveAll(companyDetailsList);
                log.info("Company details updated successfully...!!!");
            } catch (Exception ex) {
                log.error("Exception occurred while updating the company details...!!!");
                throw new ApplicationException("Exception occurred while company details update...!!!", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return companyDetailsDTOList;
    }

    @Transactional
    @Override
    public APIResponse deleteCompanyDetails(Long companyId) {
        log.info("Delete the company details data");
        Optional<CompanyDetails> result = companyDetailsRepository.findById(companyId);
        if (result.isPresent()) {
            companyDetailsRepository.deleteCompanyDetails(companyId);
            log.info("Company details deleted successfully.");
        } else {
            log.error("Invalid company details.");
            throw new ApplicationException("Invalid company details.", HttpStatus.BAD_REQUEST);
        }
        return APIResponse.builder().message("Company details deleted successfully.").status(HttpStatus.OK).build();
    }

}
