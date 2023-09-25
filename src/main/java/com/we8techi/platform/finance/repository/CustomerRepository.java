package com.we8techi.platform.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.we8techi.platform.finance.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Long> {
}