package pl.jackokamil.librarymanagementsystem;

import pl.jackokamil.librarymanagementsystem.enums.AccountStatus;

public abstract class Account {
    private int id;
    private String password;
    private AccountStatus status;
    private Person person;

    public Account(int id, String password, AccountStatus status, Person person) {
        this.id = id;
        this.password = password;
        this.status = status;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public Person getPerson() {
        return person;
    }

    public abstract boolean resetPassword();
}
