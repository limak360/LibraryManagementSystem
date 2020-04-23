package pl.jackokamil.librarymanagementsystem;

import pl.jackokamil.librarymanagementsystem.enums.BookFormat;
import pl.jackokamil.librarymanagementsystem.enums.BookStatus;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

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
                .addAuthor(new Author("Kamil", "cos opis"))
                .addAuthor(new Author("hehe", "nic"))
                .build();

        System.out.println(book);

        Book book1 = new BookItem.Builder()
                .barCode("666")
                .bookFormat(BookFormat.PAPERBACK)
                .bookStatus(BookStatus.LOANED)
                .price(122.45)
                .borrowed(new Date())
                .dueDate(new Date())
                .dateOfPurchase(new Date(11))
                .publicationDate(new Date(8))
                .ISBN("1234567")
                .title("Clean Code")
                .subject("IT")
                .publisher("Helion")
                .language("angielski")
                .numberOfPages(400)
                .addAuthor(new Author("Robert", "czysty kod"))
                .build();

        System.out.println(book1);
    }
}
