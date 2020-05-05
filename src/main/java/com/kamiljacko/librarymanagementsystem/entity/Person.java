package com.kamiljacko.librarymanagementsystem.entity;


import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
    private String email;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Person() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }
}