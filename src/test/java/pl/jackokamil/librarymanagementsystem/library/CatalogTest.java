package pl.jackokamil.librarymanagementsystem.library;

import org.junit.jupiter.api.Test;
import pl.jackokamil.librarymanagementsystem.book.BookItem;

import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {

    BookItem bookItem = new BookItem.Builder().build();

    @Test
    void ShouldPutNewBookItemInstanceIntoAMap() {
        assertTrue(Catalog.CATALOG.updateCatalog(bookItem));
    }

}