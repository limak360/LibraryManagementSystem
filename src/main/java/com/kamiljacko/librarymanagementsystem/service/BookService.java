package com.kamiljacko.librarymanagementsystem.service;

import com.kamiljacko.librarymanagementsystem.dto.BookDto;
import com.kamiljacko.librarymanagementsystem.entity.BookItem;

import java.util.List;

public interface BookService {

    void save(BookDto bookDto);

    List<BookItem> findAll();
}
