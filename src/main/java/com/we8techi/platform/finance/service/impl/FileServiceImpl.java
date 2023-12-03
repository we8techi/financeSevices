package com.we8techi.platform.finance.service.impl;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.we8techi.platform.finance.objects.FileDTO;
import com.we8techi.platform.finance.repository.FileRepository;
import com.we8techi.platform.finance.service.FileService;


@Service
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void save(MultipartFile file) throws IOException {
        FileDTO fileEntity = new FileDTO();
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setData(file.getBytes());
        fileEntity.setSize(file.getSize());

        fileRepository.save(fileEntity);
    }

    public Optional<FileDTO> getFile(String id) {
        return fileRepository.findById(id);
    }

    public List<FileDTO> getAllFiles() {
        return fileRepository.findAll();
    }
}