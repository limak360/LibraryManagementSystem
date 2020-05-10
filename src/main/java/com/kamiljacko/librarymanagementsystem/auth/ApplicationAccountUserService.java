package com.kamiljacko.librarymanagementsystem.auth;

import com.kamiljacko.librarymanagementsystem.dao.AccountDAO;
import com.kamiljacko.librarymanagementsystem.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationAccountUserService implements UserDetailsService {

    AccountDAO accountDAO;

    @Autowired
    public ApplicationAccountUserService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        Optional<Account> user = accountDAO.findAccountByName(accountName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + accountName));

        return user.map(ApplicationAccountUser::new).get();
    }
}