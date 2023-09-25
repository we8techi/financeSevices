package com.we8techi.platform.finance.config;

import com.we8techi.platform.finance.entity.Users;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Component
public class MyUserDetails implements UserDetails {

    private String userName;
    private String password;
    private String email;
    private Long companyId;
    private boolean isEnabled;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(Users user) {
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.authorities = getAuthority(user);
        this.isEnabled = user.getActive();
        this.companyId = user.getCompany().getId();
    }

    private List<GrantedAuthority> getAuthority(Users user) {
        List<String> userRoleList = user.getUserRoles().stream().map(ur -> ur.getRole().getRoleName()).collect(Collectors.toList());
        return userRoleList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    public MyUserDetails() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    @Override
    public String toString() {
        return "MyUserDetails{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", companyId=" + companyId +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
