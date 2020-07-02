package com.kamiljacko.librarymanagementsystem.repository;


import com.kamiljacko.librarymanagementsystem.dto.BookDto;
import com.kamiljacko.librarymanagementsystem.entity.BookItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookIemRepository extends JpaRepository<BookItem, Integer> {

    List<BookItem> findByTitle(String title);
}