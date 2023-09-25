package com.we8techi.platform.finance.service;


import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.UserRequest;

public interface UserRegistrationService {

    APIResponse saveUserRegistration(UserRequest userRequest);
}
