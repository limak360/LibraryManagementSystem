package pl.jackokamil.librarymanagementsystem;

import pl.jackokamil.librarymanagementsystem.enums.BookFormat;
import pl.jackokamil.librarymanagementsystem.enums.BookStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Author> lista = new ArrayList<Author>(2);
        lista.add(new Author("Kamil", "moj opis"));

        Book book = new BookItem.Builder()
                .barCode("shh2jb3")
                .bookFormat(BookFormat.AUDIOBOOK)
                .bookStatus(BookStatus.AVAILABLE)
                .price(19.99)
                .borrowed(new Date())
                .dueDate(new Date())
                .dateOfPurchase(new Date(11))
                .publicationDate(new Date(8))
                .ISBN("12323123e7")
                .title("")
                .subject("Matematyka")
                .publisher("Helion")
                .language("polski")
                .numberOfPages(30)
                .authors(lista)
                .build();
    }
}
