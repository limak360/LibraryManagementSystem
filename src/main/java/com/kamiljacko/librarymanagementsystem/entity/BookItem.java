package com.kamiljacko.librarymanagementsystem.entity;


import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class BookItem
        extends Book implements Serializable {
    private BookFormat bookFormat;
    private BookStatus bookStatus;
    private Date borrowed;
    private Date dueDate;
    private Date publicationDate;

    public BookItem() {
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

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "BookItem{" +
                "bookFormat=" + bookFormat +
                ", bookStatus=" + bookStatus +
                ", borrowed=" + borrowed +
                ", dueDate=" + dueDate +
                ", publicationDate=" + publicationDate +
                '}';
    }
}