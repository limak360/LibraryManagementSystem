package com.kamiljacko.librarymanagementsystem.dto;

import com.kamiljacko.librarymanagementsystem.entity.Author;
import com.kamiljacko.librarymanagementsystem.entity.BookFormat;
import com.kamiljacko.librarymanagementsystem.entity.BookStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

public class BookDto {
    //todo validation
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
//    private List<Author> authors =  new ArrayList<>();
    private BookFormat bookFormat;
    private BookStatus bookStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;

    public BookDto() {
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

//    public List<Author> getAuthors() {
//        return authors;
//    }
//
//    public void addAuthors(Author author) {
//        this.authors.add(author);
//    }

    public BookFormat getBookFormat() {
        return bookFormat;
    }

    public void setBookFormat(BookFormat bookFormat) {
        this.bookFormat = bookFormat;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}
