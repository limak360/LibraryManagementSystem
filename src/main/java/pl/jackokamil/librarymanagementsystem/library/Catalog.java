package pl.jackokamil.librarymanagementsystem.library;


import pl.jackokamil.librarymanagementsystem.book.Book;
import pl.jackokamil.librarymanagementsystem.book.BookItem;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Catalog implements Search {

    public static final Catalog CATALOG = new Catalog();

    private LocalDateTime creationDate;
    private static int totalBooks;
    private static int bookItemListCounter;

    private List<List<BookItem>> bookItemList;
    private Map<String, List<BookItem>> books;

    private Map<String, List> bookTitles;
    private Map<String, List> bookAuthors;
    private Map<String, List> bookSubject;
    private Map<Date, List> bookPublicationDates;

    private Catalog() {
        if (CATALOG != null) {
            throw new IllegalStateException("Catalog already constructed");
        }
        this.creationDate = LocalDateTime.now();
        this.totalBooks = 0;
        this.bookItemListCounter = 0;
        this.bookItemList = new ArrayList<>();
        this.books = new HashMap<>();
        this.bookTitles = new HashMap<>();
        this.bookAuthors = new HashMap<>();
        this.bookSubject = new HashMap<>();
        this.bookPublicationDates = new HashMap<>();
    }

    //TODO clean code testowanie ale juz dziala
    public Map<String, List<BookItem>> updateCatalog(BookItem bookItem) {
        if (!books.containsKey(bookItem.getISBN())) {
            List<BookItem> tempList = new ArrayList<>();
            tempList.add(bookItem);
            bookItemList.add(tempList);
            books.put(bookItem.getISBN(), bookItemList.get(bookItemListCounter));
            bookItemListCounter++;
        } else {
            for (List<BookItem> list : bookItemList) {
                if (list.get(0).getISBN().equals(bookItem.getISBN())) {
                    list.add(bookItem);
                }
            }
        }
        //TODO do poprawy
//        for (String name : books.keySet()) {
//            System.out.println(name);
//            for (int i = 0; i < bookItemListCounter-1; i++) {
//                System.out.println(books.get(bookItem.getISBN()).get(i));
//            }
//        }
        return books;
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
