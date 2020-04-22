package pl.jackokamil.librarymanagementsystem;

import pl.jackokamil.librarymanagementsystem.enums.BookFormat;
import pl.jackokamil.librarymanagementsystem.enums.BookStatus;

import java.util.Date;
import java.util.List;

public class BookItem
        extends Book {
    private String barCode;
    private BookFormat bookFormat;
    private BookStatus bookStatus;
    private double price;
    private Date borrowed;
    private Date dueDate;
    private Date dateOfPurchase;
    private Date publicationDate;

    public BookItem(String ISBN, String title, String subject, String publisher, String language, int numberOfPages, List<Author> authors, String barCode, BookFormat bookFormat, BookStatus bookStatus, double price, Date borrowed, Date dueDate, Date dateOfPurchase, Date publicationDate) {
        super(ISBN, title, subject, publisher, language, numberOfPages, authors);
        this.barCode = barCode;
        this.bookFormat = bookFormat;
        this.bookStatus = bookStatus;
        this.price = price;
        this.borrowed = borrowed;
        this.dueDate = dueDate;
        this.dateOfPurchase = dateOfPurchase;
        this.publicationDate = publicationDate;
    }

    public String getBarCode() {
        return barCode;
    }

    public BookFormat getBookFormat() {
        return bookFormat;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public double getPrice() {
        return price;
    }

    public Date getBorrowed() {
        return borrowed;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public boolean checkout() {
        return true;
    }
}
