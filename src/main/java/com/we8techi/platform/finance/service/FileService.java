package com.we8techi.platform.finance.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.we8techi.platform.finance.objects.FileDTO;
import com.we8techi.platform.finance.repository.FileRepository;

public interface FileService {

	public void save(MultipartFile file) throws IOException;
	
	public Optional<FileDTO> getFile(String id);

	public List<FileDTO> getAllFiles();

}
