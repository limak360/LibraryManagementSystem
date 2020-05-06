package com.kamiljacko.librarymanagementsystem.service;


import com.kamiljacko.librarymanagementsystem.entity.AccountStatus;
import com.kamiljacko.librarymanagementsystem.entity.BookFormat;
import com.kamiljacko.librarymanagementsystem.entity.BookStatus;
import com.kamiljacko.librarymanagementsystem.dao.*;
import com.kamiljacko.librarymanagementsystem.entity.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QueryExample {
    private final MemberDAO memberDAO;
    private final LibrarianDAO librarianDAO;
    private final BookIemDAO bookIemDAO;
    private Address address;
    private Person person;

    public QueryExample(MemberDAO memberDAO, LibrarianDAO librarianDAO, BookIemDAO bookIemDAO) {
        this.memberDAO = memberDAO;
        this.librarianDAO = librarianDAO;
        this.bookIemDAO = bookIemDAO;
    }

    @Transactional
    public void saveLibrarian() {
        address = new Address();
        address.setCountry("Poland");
        address.setCity("Katowice");
        address.setState("Slask");
        address.setZipCode("11-434");

        person = new Person();
        person.setName("Adas");
        person.setEmail("adas@gmail.com");
        person.setPhone("434765134");
        person.setAddress(address);

        Librarian librarian = new Librarian();
        librarian.setPassword("admin");
        librarian.setStatus(AccountStatus.ACTIVE);
        librarian.setPerson(person);
        librarianDAO.save(librarian);

        System.out.println("librarian saved");
    }

    @Transactional
    public void saveMember() {
        address = new Address();
        address.setCountry("Poland");
        address.setCity("Warszawa");
        address.setState("Mazowieckie");
        address.setZipCode("12-222");

        person = new Person();
        person.setName("Kamil");
        person.setEmail("limak360@gmail.com");
        person.setPhone("1233232");
        person.setAddress(address);

        Member member = new Member();
        member.setPassword("123");
        member.setStatus(AccountStatus.BLACKLISTED);
        member.setPerson(person);
        member.setDateOfMembership(new Date());
        member.setTotalBooksCheckedout(2);
        memberDAO.save(member);

        System.out.println("Member saved");
    }

    @Transactional
    public void getAccounts() {
        System.out.println("Member : " + memberDAO.findAll());
        System.out.println("Librarian : " + librarianDAO.findAll());
    }

    @Transactional
    public void saveBookItem() {
        Author author = new Author();
        author.setName("Bruce");
        author.setDescription("some description");
        List<Author> authorList = new ArrayList<>();
        authorList.add(author);

        BookItem bookItem = new BookItem();
        bookItem.setISBN("1234-567");
        bookItem.setTitle("Thinking in Java");
        bookItem.setSubject("IT");
        bookItem.setPublisher("Helion");
        bookItem.setLanguage("angielski");
        bookItem.setNumberOfPages(400);
        bookItem.setAuthors(authorList);
        bookItem.setBarCode("388");
        bookItem.setBookFormat(BookFormat.PAPERBACK);
        bookItem.setBookStatus(BookStatus.AVAILABLE);
        bookItem.setPrice(47.99);
        bookItem.setBorrowed(new Date());
        bookItem.setDueDate(new Date());
        bookItem.setDateOfPurchase(new Date(11));
        bookItem.setPublicationDate(new Date(8));
        bookIemDAO.save(bookItem);

        System.out.println("BookItem1 saved");

        Author author2 = new Author();
        author2.setName("Robert C.");
        author2.setDescription("desc");
        List<Author> authors = new ArrayList<>();
        authors.add(author2);

        BookItem bookItem2 = new BookItem();
        bookItem2.setISBN("443-1093");
        bookItem2.setTitle("Clean Code");
        bookItem2.setSubject("Programming");
        bookItem2.setPublisher("Helion");
        bookItem2.setLanguage("english");
        bookItem2.setNumberOfPages(270);
        bookItem2.setAuthors(authors);
        bookItem2.setBarCode("12442");
        bookItem2.setBookFormat(BookFormat.EBOOK);
        bookItem2.setBookStatus(BookStatus.LOANED);
        bookItem2.setPrice(34.12);
        bookItem2.setBorrowed(new Date());
        bookItem2.setDueDate(new Date());
        bookItem2.setDateOfPurchase(new Date());
        bookItem2.setPublicationDate(new Date());
        bookIemDAO.save(bookItem2);
        System.out.println("BookItem2 saved");
    }

    @Transactional
    public void getBookItems() {
        System.out.println("BookItems : " + bookIemDAO.findAll());
    }

    @Transactional
    public List<BookItem> getBookItem() {
        return bookIemDAO.findAll();
    }
}