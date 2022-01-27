package com.dbit.model.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {
    public static final String ROLE_PREFIX = "ROLE_";
    private final User user;
    private final Collection<SimpleGrantedAuthority> authorities;

    public UserPrincipal(User user) {
        this.user = user;
        List<SimpleGrantedAuthority> roleList = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(ROLE_PREFIX + role.getName()))
                .collect(Collectors.toList());

        List<SimpleGrantedAuthority> authorityList = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());

        this.authorities = new ArrayList<>();
        this.authorities.addAll(roleList);
        this.authorities.addAll(authorityList);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
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
}
