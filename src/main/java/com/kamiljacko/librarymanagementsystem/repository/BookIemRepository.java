package com.kamiljacko.librarymanagementsystem.repository;


import com.kamiljacko.librarymanagementsystem.entity.BookItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookIemRepository extends JpaRepository<BookItem, Integer> {
}