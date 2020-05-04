package com.kamiljacko.librarymanagementsystem.entity;

import com.kamiljacko.librarymanagementsystem.AccountStatus;

import javax.persistence.*;
import java.util.List;

@MappedSuperclass
public abstract class Account {
    @Id
    @GeneratedValue
    private int id;
    private String password;
    private AccountStatus status;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Person> person;

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }
}