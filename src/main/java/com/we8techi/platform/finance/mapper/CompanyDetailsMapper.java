package com.we8techi.platform.finance.mapper;

import com.we8techi.platform.finance.entity.CompanyDetails;
import com.we8techi.platform.finance.objects.CompanyDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.List;

/**
 * @author dhijadhav
 */

@Mapper(componentModel = "spring", imports = {LocalDate.class})
public interface CompanyDetailsMapper {

    CompanyDetailsMapper INSTANCE = Mappers.getMapper(CompanyDetailsMapper.class);

    CompanyDetails mapToCompanyDetails(CompanyDetailsDTO companyDetailsDTO);

    List<CompanyDetailsDTO> mapToCompanyDetailsDtoList(List<CompanyDetails> companyDetailsList);

    List<CompanyDetails> mapToCompanyDetailsList(List<CompanyDetailsDTO> companyDetailsDTOList);

    CompanyDetailsDTO mapToCompanyDetailsDto(CompanyDetails companyDetails);
}
