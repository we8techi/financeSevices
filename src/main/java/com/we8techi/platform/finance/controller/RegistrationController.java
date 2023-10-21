package com.we8techi.platform.finance.controller;

import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.UserRequest;
import com.we8techi.platform.finance.service.UserRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@PreAuthorize("isAuthenticated() and " + "hasAuthority('ADMIN')")
public class RegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping("/user/registration")
    public ResponseEntity<APIResponse> registerUser(@RequestBody UserRequest userRequest) {
        log.info("Inside Registration controller.......");

        APIResponse apiResponse = userRegistrationService.saveUserRegistration(userRequest);

        return new ResponseEntity<>(apiResponse, apiResponse.getStatus());
    }
}
