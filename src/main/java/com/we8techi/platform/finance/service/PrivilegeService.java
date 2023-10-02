package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.objects.PrivilegeDTO;

import java.util.List;

public interface PrivilegeService {

    public List<PrivilegeDTO> getPrivilegeDtoList(String email);
}
