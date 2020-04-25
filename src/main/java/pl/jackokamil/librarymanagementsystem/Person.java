package pl.jackokamil.librarymanagementsystem;

import javax.validation.constraints.NotNull;

public class Person {
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String phone;
    @NotNull
    private Address address;

    public Person(String name, String email, String phone, Address address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return super.toString() + " " +
                "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }
}
