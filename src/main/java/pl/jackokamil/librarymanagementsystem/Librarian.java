package pl.jackokamil.librarymanagementsystem;

import pl.jackokamil.librarymanagementsystem.enums.AccountStatus;

public class Librarian
        extends Account {

    public static class Builder extends Account.BaseBuilder<Builder> {
        @Override
        Account build() {
            return new Librarian(self());
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public Librarian(Builder builder) {
        super(builder);
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

    public String toString() {
        return super.toString();
    }
}
