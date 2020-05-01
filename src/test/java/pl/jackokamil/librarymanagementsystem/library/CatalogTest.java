package pl.jackokamil.librarymanagementsystem.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.jackokamil.librarymanagementsystem.book.BookItem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {

    BookItem bookItem;
    BookItem bookItem2;
    BookItem bookItem3;
    BookItem bookItem4;
    BookItem bookItem5;
    BookItem bookItem6;

    @BeforeEach
    void SetUp() {
        bookItem = new BookItem.Builder().ISBN("12344444").build();
        bookItem2 = new BookItem.Builder().ISBN("14").build();
        bookItem3 = new BookItem.Builder().ISBN("1234").build();
        bookItem4 = new BookItem.Builder().ISBN("14").build();
        bookItem5 = new BookItem.Builder().ISBN("12").build();
        bookItem6 = new BookItem.Builder().ISBN("1234").build();
    }


    @Test
    void ShouldPutNewBookItemInstanceIntoAMap() {
        assertEquals(3,Catalog.CATALOG.updateCatalog(bookItem4).size());
        assertEquals(3,Catalog.CATALOG.updateCatalog(bookItem2).size());
    }

}