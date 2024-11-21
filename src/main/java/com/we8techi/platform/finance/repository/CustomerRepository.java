package com.we8techi.platform.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.we8techi.platform.finance.entity.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("FROM Customer where companyId = :companyId")
    List<Customer> findAllCustomersForCompany(@Param("companyId") Long companyId);

    @Query("FROM Customer where companyId = :companyId and id = :customerId and active = true")
    Optional<Customer> getCustomerByCompIdAndCustId(@Param("companyId") Long companyId, @Param("customerId") Long customerId);

    @Modifying
    @Query("UPDATE Customer SET active = false where id = :customerId")
    int deleteCustomerDetails(@Param("customerId") Long customerId);
}