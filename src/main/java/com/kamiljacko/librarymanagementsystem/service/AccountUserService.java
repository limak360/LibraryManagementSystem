package com.kamiljacko.librarymanagementsystem.service;

import com.kamiljacko.librarymanagementsystem.dao.AccountUserDAO;
import com.kamiljacko.librarymanagementsystem.entity.AccountUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountUserService {
    private final AccountUserDAO accountUserDAO;

    @Autowired
    public AccountUserService(AccountUserDAO accountUserDAO) {
        this.accountUserDAO = accountUserDAO;
    }

    public void save(AccountUser user) {
        accountUserDAO.save(user);
    }
}