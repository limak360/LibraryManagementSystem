package com.kamiljacko.librarymanagementsystem.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Author> authors;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", publisher='" + publisher + '\'' +
                ", language='" + language + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", authors=" + authors +
                '}';
    }
}