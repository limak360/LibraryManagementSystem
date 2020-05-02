package pl.jackokamil.librarymanagementsystem.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.jackokamil.librarymanagementsystem.book.Author;
import pl.jackokamil.librarymanagementsystem.book.BookFormat;
import pl.jackokamil.librarymanagementsystem.book.BookItem;
import pl.jackokamil.librarymanagementsystem.book.BookStatus;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {

    BookItem book1;
    BookItem book2;
    BookItem book3;
    BookItem book4;
    BookItem book5;

    List<BookItem> lista;

    @BeforeEach
    void SetUp() {
        book1 = new BookItem.Builder()
                .barCode("388")
                .bookFormat(BookFormat.PAPERBACK)
                .bookStatus(BookStatus.AVAILABLE)
                .price(47.99)
                .borrowed(new Date())
                .dueDate(new Date())
                .dateOfPurchase(new Date(11))
                .publicationDate(new Date(8))
                .ISBN("1234567")
                .title("Thinking in Java")
                .subject("IT")
                .publisher("Helion")
                .language("angielski")
                .numberOfPages(400)
                .addAuthor(new Author("Bruce", ""))
                .build();
        book2 = new BookItem.Builder()
                .barCode("454")
                .bookFormat(BookFormat.PAPERBACK)
                .bookStatus(BookStatus.AVAILABLE)
                .price(47.99)
                .borrowed(new Date())
                .dueDate(new Date())
                .dateOfPurchase(new Date(11))
                .publicationDate(new Date(8))
                .ISBN("566")
                .title("Clean Code")
                .subject("IT")
                .publisher("Helion")
                .language("angielski")
                .numberOfPages(400)
                .addAuthor(new Author("Robert", "czysty kod"))
                .build();
        book3 = new BookItem.Builder()
                .barCode("8900")
                .bookFormat(BookFormat.PAPERBACK)
                .bookStatus(BookStatus.AVAILABLE)
                .price(47.99)
                .borrowed(new Date())
                .dueDate(new Date())
                .dateOfPurchase(new Date(11))
                .publicationDate(new Date(8))
                .ISBN("566")
                .title("Clean Code")
                .subject("IT")
                .publisher("Helion")
                .language("angielski")
                .numberOfPages(400)
                .addAuthor(new Author("Robert", "czysty kod"))
                .build();
        book4 = new BookItem.Builder()
                .barCode("766")
                .bookFormat(BookFormat.PAPERBACK)
                .bookStatus(BookStatus.AVAILABLE)
                .price(47.99)
                .borrowed(new Date())
                .dueDate(new Date())
                .dateOfPurchase(new Date(11))
                .publicationDate(new Date(8))
                .ISBN("322")
                .title("Design Patterns")
                .subject("IT")
                .publisher("Helion")
                .language("angielski")
                .numberOfPages(400)
                .addAuthor(new Author("GOF", "opis"))
                .build();
        book5 = new BookItem.Builder()
                .barCode("1982")
                .bookFormat(BookFormat.PAPERBACK)
                .bookStatus(BookStatus.AVAILABLE)
                .price(47.99)
                .borrowed(new Date())
                .dueDate(new Date())
                .dateOfPurchase(new Date(11))
                .publicationDate(new Date(8))
                .ISBN("12345678")
                .title("Thinking in Java")
                .subject("IT")
                .publisher("Helion")
                .language("angielski")
                .numberOfPages(400)
                .addAuthor(new Author("Bruce", "ooo"))
                .build();
    }

    @Test
    void ShouldNotPutNewBookItemInAMap() {
        assertEquals(1, Catalog.CATALOG.updateCatalog(book2).size());
        assertEquals(1, Catalog.CATALOG.updateCatalog(book3).size());
    }

    @Test
    void ShouldPutNewBookItemInstanceIntoAMap() {
        assertEquals(2, Catalog.CATALOG.updateCatalog(book1).size());
        assertEquals(3, Catalog.CATALOG.updateCatalog(book4).size());
    }


    @Test
    void ShouldFindBookOfProvidedTitle() {
        lista = new ArrayList<>();
        lista.add(book2);
        lista.add(book3);
        assertEquals(lista, Catalog.CATALOG.searchByTitle("Clean Code"));
    }
}