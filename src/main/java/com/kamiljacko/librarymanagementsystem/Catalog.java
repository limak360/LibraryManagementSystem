package com.kamiljacko.librarymanagementsystem;


import com.kamiljacko.librarymanagementsystem.entity.BookItem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Catalog implements Search {
    public static final Catalog CATALOG = new Catalog();

    private static int totalBooks;
    private static int bookItemListCounter;

    private final LocalDateTime creationDate;

    private final List<List<BookItem>> bookItemList;
    private final Map<String, List<BookItem>> books;

    private final Map<String, List> bookTitles;
    private final Map<String, List> bookAuthors;
    private final Map<String, List> bookSubject;
    private final Map<Date, List> bookPublicationDates;

    private Catalog() {
        if (CATALOG != null) {
            throw new IllegalStateException("Catalog already constructed");
        }
        totalBooks = 0;
        bookItemListCounter = 0;
        this.creationDate = LocalDateTime.now();
        this.bookItemList = new ArrayList<>();
        this.books = new HashMap<>();
        this.bookTitles = new HashMap<>();
        this.bookAuthors = new HashMap<>();
        this.bookSubject = new HashMap<>();
        this.bookPublicationDates = new HashMap<>();
    }

    //TODO clean code, testowanie
    public Map<String, List<BookItem>> updateCatalog(BookItem bookItem) {
        if (!books.containsKey(bookItem.getISBN())) {
            bookItemList.add(addBookItem(bookItem));
            books.put(bookItem.getISBN(), bookItemList.get(bookItemListCounter));
            bookItemListCounter++;
        } else {
            for (List<BookItem> list : bookItemList) {
                if (list.get(0).getISBN().equals(bookItem.getISBN())) {
                    list.add(bookItem);
                }
            }
        }
        return books;
    }

    //splitted
    private List<BookItem> addBookItem(BookItem bookItem) {
        List<BookItem> tempList = new ArrayList<>();
        tempList.add(bookItem);
        return tempList;
    }

    public void printMap() {
        for (String name : books.keySet()) {
            System.out.println("Key: " + name);
            System.out.print("Values: ");
            books.get(name).forEach(System.out::println);
        }
    }

    //strategy?
    @Override
    public List<BookItem> searchByTitle(String title) {
        for (List<BookItem> list : bookItemList) {
            int i = 0;
            while (i < list.size()) {
                if (list.get(i).getTitle().equals(title)) {
                    list.forEach(bookItem -> bookItem.getTitle());
                    return list;
                }
                i++;
            }
        }
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