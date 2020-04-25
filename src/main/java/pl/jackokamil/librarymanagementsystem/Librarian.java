package pl.jackokamil.librarymanagementsystem;

import pl.jackokamil.librarymanagementsystem.enums.AccountStatus;

public class Librarian
        extends Account {

    private static Catalog catalog;

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
        catalog.updateCatalog(bookItem);
        return false;
    }

    public boolean blockMember(Member member) {
        if (member.getStatus() != AccountStatus.BLACKLISTED) {
            member.setStatus(AccountStatus.BLACKLISTED);
            return true;
        }
        return false;
    }

    public boolean unBlockMember(Member member) {
        if (member.getStatus() == AccountStatus.BLACKLISTED) {
            member.setStatus(AccountStatus.ACTIVE);
            return true;
        }
        return false;
    }

    public String toString() {
        return super.toString();
    }
}
