package com.we8techi.platform.finance.repository;

import com.we8techi.platform.finance.entity.CompanyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dhijadhav
 */

@Repository
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Long> {
}
