package pl.jackokamil.librarymanagementsystem;

import javax.validation.constraints.NotNull;

public class Library {
    @NotNull
    private String name;
    @NotNull
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
