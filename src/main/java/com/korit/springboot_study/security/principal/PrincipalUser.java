package com.korit.springboot_study.security.principal;

import com.korit.springboot_study.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class PrincipalUser implements UserDetails {
    private User user;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정 만료 여부
        return user.getIsAccountNonExpired() == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정 잠금 여부
        return user.getIsAccountNonLocked() == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 계정 인가 여부
        return user.getIsCredentialsNonExpired() == 1;
    }

    @Override
    public boolean isEnabled() {
        // 계정 활성 여부
        return user.getIsEnabled() == 1;
    }
}
