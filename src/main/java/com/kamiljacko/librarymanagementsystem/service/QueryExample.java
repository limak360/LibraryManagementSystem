package com.kamiljacko.librarymanagementsystem.service;


import com.kamiljacko.librarymanagementsystem.entity.AccountStatus;
import com.kamiljacko.librarymanagementsystem.dao.*;
import com.kamiljacko.librarymanagementsystem.entity.*;
import com.kamiljacko.librarymanagementsystem.security.ApplicationUserRole;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Date;

@Service
public class QueryExample {
    private final MemberDAO memberDAO;
    private final LibrarianDAO librarianDAO;
    private final BookIemDAO bookIemDAO;
    private Address address;
    private Person person;

    PasswordEncoder passwordEncoder;

    @Autowired
    public QueryExample(MemberDAO memberDAO, LibrarianDAO librarianDAO, BookIemDAO bookIemDAO, PasswordEncoder passwordEncoder) {
        this.memberDAO = memberDAO;
        this.librarianDAO = librarianDAO;
        this.bookIemDAO = bookIemDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void saveAdmin() {
        address = new Address();
        address.setCountry("UK");
        address.setCity("London");
        address.setState("state");
        address.setZipCode("22-22");

        person = new Person();
        person.setName("Jeff");
        person.setEmail("jeff@gmail.com");
        person.setPhone("433332313");
        person.setAddress(address);

        Librarian librarian = new Librarian();
        librarian.setName("Admin");
        librarian.setApplicationUserRole(ApplicationUserRole.ADMIN);
        librarian.setActive(true);
        librarian.setPassword(passwordEncoder.encode("admin"));
        librarian.setStatus(AccountStatus.NONE);
        librarian.setPerson(person);
        librarianDAO.save(librarian);

        System.out.println("Admin saved");
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
        librarian.setName("Mark");
        librarian.setApplicationUserRole(ApplicationUserRole.LIBRARIAN);
        librarian.setActive(true);
        librarian.setPassword(passwordEncoder.encode("librarian"));
        librarian.setStatus(AccountStatus.ACTIVE);
        librarian.setPerson(person);
        librarianDAO.save(librarian);

        System.out.println("Librarian saved");
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
        member.setName("Kamil");
        member.setApplicationUserRole(ApplicationUserRole.MEMBER);
        member.setActive(true);
        member.setPassword(passwordEncoder.encode("member"));
        member.setStatus(AccountStatus.CLOSED);
        member.setPerson(person);
        member.setDateOfMembership(new Date());
        member.setTotalBooksCheckedout(2);
        memberDAO.save(member);

        System.out.println("Member saved");
    }

//    @Transactional
//    public void getAccounts() {
//        System.out.println("Member : " + memberDAO.findAll());
//        System.out.println("Librarian : " + librarianDAO.findAll());
//    }
//
//    @Transactional
//    public List<BookItem> getBookItem() {
//        return bookIemDAO.findAll();
//    }
}