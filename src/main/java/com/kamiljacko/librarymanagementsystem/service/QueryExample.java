package com.kamiljacko.librarymanagementsystem.service;


import com.kamiljacko.librarymanagementsystem.dao.AccountDAO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class QueryExample {
    final AccountDAO accountDAO;

    public QueryExample(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Transactional
    public void simpleQuery() {
        System.out.println(accountDAO.findById(1));
    }
}