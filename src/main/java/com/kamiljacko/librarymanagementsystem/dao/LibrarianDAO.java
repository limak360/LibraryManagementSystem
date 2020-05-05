package com.kamiljacko.librarymanagementsystem.dao;


import com.kamiljacko.librarymanagementsystem.entity.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianDAO extends JpaRepository<Librarian, Integer> {
}