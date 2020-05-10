package com.kamiljacko.librarymanagementsystem.auth;


import com.kamiljacko.librarymanagementsystem.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class ApplicationAccountUser implements UserDetails {

    private final String accountName;
    private final String password;
    private final boolean active;
    private final Set<? extends GrantedAuthority> grantedAuthorities;

    public ApplicationAccountUser(Account account) {
        this.accountName = account.getName();
        this.password = account.getPassword();
        this.active = account.isActive();
        this.grantedAuthorities = account.getApplicationUserRole().getGrantedAuthorities();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return accountName;
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
        return active;
    }
}