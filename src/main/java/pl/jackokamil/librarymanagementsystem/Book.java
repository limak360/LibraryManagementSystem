package pl.jackokamil.librarymanagementsystem;

import java.util.List;

public abstract class Book {
    private String ISBN;
    private String title;
    private String Subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private List<Author> authors;

    //TODO builder
    public Book(String ISBN, String title, String subject, String publisher, String language, int numberOfPages, List<Author> authors) {
        this.ISBN = ISBN;
        this.title = title;
        Subject = subject;
        this.publisher = publisher;
        this.language = language;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }


    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return Subject;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getLanguage() {
        return language;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public List<Author> getAuthors() {
        return authors;
    }
}
