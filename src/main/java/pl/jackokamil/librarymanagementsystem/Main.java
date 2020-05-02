package pl.jackokamil.librarymanagementsystem;


import pl.jackokamil.librarymanagementsystem.account.*;
import pl.jackokamil.librarymanagementsystem.book.*;
import pl.jackokamil.librarymanagementsystem.library.Library;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Librarian librarian = new Librarian.Builder()
                .id(1)
                .password("admin")
                .status(AccountStatus.ACTIVE)
                .person(new Person("Kamil", "limak36@gmail.com", "234345456", new Address.Builder()
                        .country("Poland")
                        .city("Gliwice")
                        .state("Slask")
                        .zipCode("123-123")
                        .streetAddress("Akademicka 16")
                        .build()))
                .build();

        Member member = new Member.Builder()
                .dateOfMembership(new Date())
                .totalBooksCheckedout(0)
                .id(1)
                .password("member")
                .status(AccountStatus.ACTIVE)
                .person(new Person("Marcin", "marcin25@gmail.com", "123321456", new Address.Builder()
                        .country("Poland")
                        .city("Katowice")
                        .state("Slask")
                        .zipCode("156-111")
                        .streetAddress("Marszalkowska 2")
                        .build()))
                .build();

        Library library = new Library("Biblioteka Glowna w Katowicach", new Address
                .Builder()
                .country("Poland")
                .city("Katowice")
                .state("Slask")
                .zipCode("156-111")
                .streetAddress("Katowicka")
                .build());

        library.addLibrarian(librarian);
        library.addMember(member);


        BookItem book1 = new BookItem.Builder()
                .barCode("666")
                .bookFormat(BookFormat.PAPERBACK)
                .bookStatus(BookStatus.AVAILABLE)
                .price(47.99)
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


        System.out.println(library.getMember().get(0).getStatus());
        library.getLibrarian().get(0).blockMember(library.getMember().get(0));
        System.out.println(library.getMember().get(0).getStatus());

        //add book item
        library.getLibrarian().get(0).addBookItem(book1);
    }
}
