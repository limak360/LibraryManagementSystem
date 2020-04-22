package pl.jackokamil.librarymanagementsystem;

import pl.jackokamil.librarymanagementsystem.enums.AccountStatus;

public class Librarian
        extends Account {

    public Librarian(int id, String password, AccountStatus status, Person person) {
        super(id, password, status, person);
    }

    public boolean addBookItem(BookItem bookItem) {
        return false;
    }

    public boolean blockMember(Member member) {
        return false;
    }

    public boolean unBlockMember(Member member) {
        return false;
    }

    public boolean resetPassword() {
        return false;
    }
}
