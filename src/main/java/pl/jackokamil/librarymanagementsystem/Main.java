package pl.jackokamil.librarymanagementsystem;

import pl.jackokamil.librarymanagementsystem.enums.AccountStatus;
import pl.jackokamil.librarymanagementsystem.enums.BookFormat;
import pl.jackokamil.librarymanagementsystem.enums.BookStatus;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

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

        Account account = new Member.Builder()
                .totalBooksCheckedout(111)
                .dateOfMembership(new Date())
                .id(1)
                .password("onie")
                .status(AccountStatus.ACTIVE)
                .person(new Person("Kamil","limak@","208383535",new Address("Polska","Warszawa","Mazowieckie","3333","adres")))
                .build();

        System.out.println(account);

        Account account1 = new Librarian.Builder()
                .id(33)
                .build();

        System.out.println(account1);
    }
}
