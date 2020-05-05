package com.kamiljacko.librarymanagementsystem.dao;


import com.kamiljacko.librarymanagementsystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDAO extends JpaRepository<Author, Integer> {
}