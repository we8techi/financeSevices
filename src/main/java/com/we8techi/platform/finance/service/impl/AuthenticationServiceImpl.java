package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.config.MyUserDetails;
import com.we8techi.platform.finance.exception.ApplicationException;
import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.AuthenticationRequest;
import com.we8techi.platform.finance.objects.PrivilegeDTO;
import com.we8techi.platform.finance.service.AuthenticationService;
import com.we8techi.platform.finance.service.MyUserDetailsService;
import com.we8techi.platform.finance.service.PrivilegeService;
import com.we8techi.platform.finance.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationProvider authenticationProvider;

    private final MyUserDetailsService userDetailsService;

    private final PrivilegeService privilegeService;

    private final JwtUtil jwtUtil;

    @Override
    @Transactional
    public String authenticate(AuthenticationRequest authenticationRequest) {
        try {
            authenticationProvider
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
            MyUserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());

            List<PrivilegeDTO> privilegeDTOList = privilegeService.getPrivilegeDtoList(userDetails.getEmail());
            userDetails.setPrivilegeDTOS(privilegeDTOList.stream().collect(Collectors.toSet()));

            return jwtUtil.generateToken(userDetails);
        } catch (Exception ex) {
            log.error("Bad credentials...!!! message ={}", ex.getMessage());
            throw new ApplicationException("Exception Occurred while login !!! ", HttpStatus.FORBIDDEN);
        }
    }
}
