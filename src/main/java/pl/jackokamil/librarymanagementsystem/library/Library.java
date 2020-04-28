package pl.jackokamil.librarymanagementsystem.library;


import pl.jackokamil.librarymanagementsystem.account.Address;

public class Library {

    private String name;
    private Address address;

    public Library(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
