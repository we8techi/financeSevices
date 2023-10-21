package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.config.MyUserDetails;
import com.we8techi.platform.finance.entity.Users;
import com.we8techi.platform.finance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.getByUserName(username);
        return user.isPresent() ? new MyUserDetails(user.get()) : null;
    }
}
