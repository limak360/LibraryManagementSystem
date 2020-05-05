package com.kamiljacko.librarymanagementsystem.model;


import com.kamiljacko.librarymanagementsystem.entity.BookItem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Catalog implements Search {
    public static final Catalog CATALOG = new Catalog();

    private static int totalBooks;

    private final LocalDateTime creationDate;

    private final Map<String, List> bookTitles;
    private final Map<String, List> bookAuthors;
    private final Map<String, List> bookSubject;
    private final Map<Date, List> bookPublicationDates;

    private Catalog() {
        if (CATALOG != null) {
            throw new IllegalStateException("Catalog already constructed");
        }
        totalBooks = 0;
        this.creationDate = LocalDateTime.now();
        this.bookTitles = new HashMap<>();
        this.bookAuthors = new HashMap<>();
        this.bookSubject = new HashMap<>();
        this.bookPublicationDates = new HashMap<>();
    }


    public Map<String, List<BookItem>> updateCatalog(BookItem bookItem) {
        return null;
    }


    //strategy?
    @Override
    public List<BookItem> searchByTitle(String title) {
        return null; //throw custom exception?
    }

    @Override
    public List<BookItem> searchByAuthor(String author) {
        return null;
    }

    @Override
    public List<BookItem> searchBySubject(String subject) {
        return null;
    }

    @Override
    public List<BookItem> searchByPubDate(Date publishDate) {
        return null;
    }

    public String getCreationDate() {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return creationDate.format(myFormatObj);
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public Map<String, List> getBookTitles() {
        return bookTitles;
    }

    public Map<String, List> getBookAuthors() {
        return bookAuthors;
    }

    public Map<String, List> getBookSubject() {
        return bookSubject;
    }

    public Map<Date, List> getBookPublicationDates() {
        return bookPublicationDates;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "creationDate=" + creationDate +
                ", totalBooks=" + totalBooks +
                ", bookTitles=" + bookTitles +
                ", bookAuthors=" + bookAuthors +
                ", bookSubject=" + bookSubject +
                ", bookPublicationDates=" + bookPublicationDates +
                '}';
    }
}