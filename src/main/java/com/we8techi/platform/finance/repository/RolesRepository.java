package com.we8techi.platform.finance.repository;

import com.we8techi.platform.finance.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

    @Query("From Roles where id = :id")
    Optional<Roles> findById(@Param("id") Long id);
}
