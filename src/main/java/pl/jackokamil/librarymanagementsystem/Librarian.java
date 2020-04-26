package pl.jackokamil.librarymanagementsystem;

import pl.jackokamil.librarymanagementsystem.enums.AccountStatus;

public class Librarian
        extends Account {

    private Catalog catalog = new Catalog();

    public static class Builder extends Account.BaseBuilder<Builder> {
        @Override
        public Librarian build() {
            return new Librarian(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Librarian(Builder builder) {
        super(builder);
    }

    //TODO lambda ? add/remove/update
    public boolean addBookItem(BookItem bookItem) {
        catalog.updateCatalog(bookItem);
        return false;
    }

    public boolean removeBookItem(BookItem bookItem) {
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
