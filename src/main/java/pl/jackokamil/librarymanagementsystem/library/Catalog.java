package pl.jackokamil.librarymanagementsystem.library;


import pl.jackokamil.librarymanagementsystem.book.Book;
import pl.jackokamil.librarymanagementsystem.book.BookItem;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog implements Search {

    private LocalDateTime creationDate;
    private static int totalBooks;
    private Map<String,List<BookItem>> book;
    private Map<String, List> bookTitles;
    private Map<String, List> bookAuthors;
    private Map<String, List> bookSubject;
    private Map<Date, List> bookPublicationDates;

    public static final Catalog CATALOG = new Catalog();

    private Catalog() {
        this.creationDate = LocalDateTime.now();
        this.totalBooks = 0;
        this.book = new HashMap<>();
        this.bookTitles = new HashMap<>();
        this.bookAuthors = new HashMap<>();
        this.bookSubject = new HashMap<>();
        this.bookPublicationDates = new HashMap<>();
        if (CATALOG != null) {
            throw new IllegalStateException("Catalog already constructed");
        }
    }

    public String getCreationDate() {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDate = creationDate.format(myFormatObj);
        return formattedDate;
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

    public boolean updateCatalog(List<BookItem> bookItem) {
//            book.put(bookItem.get(0).getISBN(), bookItem);
            totalBooks++;
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
