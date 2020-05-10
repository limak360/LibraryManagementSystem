package com.kamiljacko.librarymanagementsystem.dao;

import com.kamiljacko.librarymanagementsystem.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountDAO extends JpaRepository<Account,Integer> {
    Optional<Account> findAccountByName(String name);
}
