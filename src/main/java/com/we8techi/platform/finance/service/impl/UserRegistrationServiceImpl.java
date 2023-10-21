package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.entity.CompanyDetails;
import com.we8techi.platform.finance.entity.Roles;
import com.we8techi.platform.finance.entity.UserRoles;
import com.we8techi.platform.finance.entity.Users;
import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.UserRequest;
import com.we8techi.platform.finance.repository.CompanyDetailsRepository;
import com.we8techi.platform.finance.repository.RolesRepository;
import com.we8techi.platform.finance.repository.UserRepository;
import com.we8techi.platform.finance.repository.UserRolesRepository;
import com.we8techi.platform.finance.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @author dhijadhav
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final UserRepository userRepository;

    private final UserRolesRepository userRolesRepository;

    private final RolesRepository rolesRepository;

    private final CompanyDetailsRepository companyDetailsRepository;

    @Override
    public APIResponse saveUserRegistration(UserRequest userRequest) {

        try {
            Optional<Roles> roles = rolesRepository.findById(userRequest.getRoleId());
            Optional<CompanyDetails> companyDetails = companyDetailsRepository.findById(userRequest.getCompanyId());
            if(roles.isPresent() && companyDetails.isPresent()){
                Users users = Users.builder()
                        .userName(userRequest.getUserName())
                        .email(userRequest.getEmail())
                        .password(userRequest.getPassword())
                        .company(companyDetails.get())
                        .build();
                users.setActive(true);
                users.setCreatedBy("System");
                users.setUpdatedBy("System");
                users.setCreated(new Date());
                users.setUpdated(new Date());

                users = userRepository.save(users);

                UserRoles userRoles = UserRoles.builder().user(users).role(roles.get()).build();
                userRoles.setActive(true);
                userRoles.setCreatedBy("System");
                userRoles.setUpdatedBy("System");
                userRoles.setCreated(new Date());
                userRoles.setUpdated(new Date());

                userRolesRepository.save(userRoles);

                return APIResponse.builder().message("User saved successfully").status(HttpStatus.OK).build();
            }

        } catch (Exception ex) {
            log.error("Exception occurred while user save with message={}", ex.getMessage());
        }
        return APIResponse.builder().message("Error occurred while user save.").status(HttpStatus.BAD_REQUEST).build();
    }
}
