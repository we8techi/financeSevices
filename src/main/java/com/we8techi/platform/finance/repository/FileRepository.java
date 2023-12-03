package com.we8techi.platform.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.we8techi.platform.finance.objects.FileDTO;


@Repository
public interface FileRepository extends JpaRepository<FileDTO, String> {
}