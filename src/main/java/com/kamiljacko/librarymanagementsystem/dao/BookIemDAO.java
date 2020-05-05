package com.kamiljacko.librarymanagementsystem.dao;


import com.kamiljacko.librarymanagementsystem.entity.BookItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookIemDAO extends JpaRepository<BookItem, Integer> {
}