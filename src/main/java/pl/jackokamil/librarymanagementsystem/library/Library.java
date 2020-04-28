package pl.jackokamil.librarymanagementsystem.library;


import pl.jackokamil.librarymanagementsystem.account.Address;
import pl.jackokamil.librarymanagementsystem.account.Librarian;
import pl.jackokamil.librarymanagementsystem.account.Member;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private Address address;
    private List<Librarian> librarians = new ArrayList<>();
    private List<Member> members = new ArrayList<>();


    public Library(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<Librarian> getLibrarian() {
        return librarians;
    }

    public List<Member> getMember() {
        return members;
    }

    public void printLibrarians() {
        librarians.forEach(System.out::println);
    }

    public void printMembers() {
        members.forEach(System.out::println);
    }
}
