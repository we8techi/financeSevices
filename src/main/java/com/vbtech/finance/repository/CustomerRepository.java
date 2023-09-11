package com.vbtech.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbtech.finance.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer , Integer> {
}