package com.kamiljacko.librarymanagementsystem.security.repository;


import com.kamiljacko.librarymanagementsystem.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
