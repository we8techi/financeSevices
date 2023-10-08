package com.we8techi.platform.finance.repository;

import com.we8techi.platform.finance.entity.CompanyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author dhijadhav
 */

@Repository
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Long> {

    @Modifying
    @Query("UPDATE CompanyDetails SET active = false where id = :companyId")
    int deleteCompanyDetails(@Param("companyId") Long companyId);
}
