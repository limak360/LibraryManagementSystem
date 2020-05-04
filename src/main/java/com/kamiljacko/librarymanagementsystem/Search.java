package com.kamiljacko.librarymanagementsystem;

import com.kamiljacko.librarymanagementsystem.entity.BookItem;

import java.util.Date;
import java.util.List;

public interface Search {
    public List<BookItem> searchByTitle(String title);
    public List<BookItem> searchByAuthor(String author);
    public List<BookItem> searchBySubject(String subject);
    public List<BookItem> searchByPubDate(Date publishDate);
}
