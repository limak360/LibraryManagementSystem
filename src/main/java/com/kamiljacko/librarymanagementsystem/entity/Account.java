package com.kamiljacko.librarymanagementsystem.entity;

import com.kamiljacko.librarymanagementsystem.security.ApplicationUserRole;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String password;
    private ApplicationUserRole applicationUserRole;
    private boolean active;
    private AccountStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ApplicationUserRole getApplicationUserRole() {
        return applicationUserRole;
    }

    public void setApplicationUserRole(ApplicationUserRole applicationUserRole) {
        this.applicationUserRole = applicationUserRole;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}