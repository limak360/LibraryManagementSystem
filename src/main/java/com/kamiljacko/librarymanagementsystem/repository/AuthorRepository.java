package com.kamiljacko.librarymanagementsystem.repository;


import com.kamiljacko.librarymanagementsystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}