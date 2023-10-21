package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.Privilege;
import com.we8techi.platform.finance.mapper.PrivilegeMapper;
import com.we8techi.platform.finance.objects.PrivilegeDTO;
import com.we8techi.platform.finance.repository.PrivilegeRepository;
import com.we8techi.platform.finance.service.PrivilegeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    private final PrivilegeRepository privilegeRepository;

    @Override
    public List<PrivilegeDTO> getPrivilegeDtoList(String email) {
        List<Privilege> privilegeList = privilegeRepository.getPrivilegeByEmail(email);
        return PrivilegeMapper.INSTANCE.mapToPrivilegeDtoList(privilegeList);
    }
}
