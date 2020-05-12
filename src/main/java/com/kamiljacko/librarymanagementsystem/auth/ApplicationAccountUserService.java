package com.kamiljacko.librarymanagementsystem.auth;


import com.kamiljacko.librarymanagementsystem.dao.AccountUserDAO;
import com.kamiljacko.librarymanagementsystem.entity.AccountUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationAccountUserService implements UserDetailsService {

    AccountUserDAO accountUserDAO;

    @Autowired
    public ApplicationAccountUserService(AccountUserDAO accountUserDAO) {
        this.accountUserDAO = accountUserDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        Optional<AccountUser> user = accountUserDAO.findAccountUserByName(accountName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + accountName));

        return user.map(ApplicationAccountUser::new).get();
    }
}