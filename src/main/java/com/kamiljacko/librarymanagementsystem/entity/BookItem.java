package com.kamiljacko.librarymanagementsystem.entity;


import com.kamiljacko.librarymanagementsystem.BookFormat;
import com.kamiljacko.librarymanagementsystem.BookStatus;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class BookItem
        extends Book implements Serializable {
    private String barCode;
    private BookFormat bookFormat;
    private BookStatus bookStatus;
    private double price;
    private Date borrowed;
    private Date dueDate;
    private Date dateOfPurchase;
    private Date publicationDate;

    public BookItem() {
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Date borrowed) {
        this.borrowed = borrowed;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}