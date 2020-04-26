package pl.jackokamil.librarymanagementsystem;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Catalog implements Search {
    @NotNull
    private Date creationDate;
    @NotNull
    private int totalBooks;
    private Map<String, List> bookTitles;
    private Map<String, List> bookAuthors;
    private Map<String, List> bookSubject;
    private Map<Date, List> bookPublicationDates;
    private HibernateConfig config = new HibernateConfig();

    public Date getCreationDate() {
        return creationDate;
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

    public boolean updateCatalog(BookItem bookItem) {
        try {
            config.getSession().beginTransaction();
            config.getSession().save(bookItem);
            config.getSession().getTransaction().commit();
        } finally {
            config.getSession().close();
        }
        return true;
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return null;
    }

    @Override
    public List<Book> searchBySubject(String subject) {
        return null;
    }

    @Override
    public List<Book> searchByPubDate(Date publishDate) {
        return null;
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
