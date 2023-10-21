package com.we8techi.platform.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.we8techi.platform.finance.entity.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Long> {

    @Modifying
    @Query("UPDATE Customer SET active = false where id = :customerId")
    int deleteCustomerDetails(@Param("customerId") Long customerId);
}