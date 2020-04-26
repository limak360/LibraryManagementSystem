package pl.jackokamil.librarymanagementsystem;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Member
        extends Account {
    @NotNull
    private Date dateOfMembership;
    @NotNull
    private int totalBooksCheckedout;

    public static class Builder extends Account.BaseBuilder<Builder> {

        private Date dateOfMembership;
        private int totalBooksCheckedout;

        public Builder dateOfMembership(Date dateOfMembership) {
            this.dateOfMembership = dateOfMembership;
            return this;
        }

        public Builder totalBooksCheckedout(int totalBooksCheckedout) {
            this.totalBooksCheckedout = totalBooksCheckedout;
            return this;
        }

        @Override
        Member build() {
            return new Member(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public Member(Builder builder) {
        super(builder);
        this.dateOfMembership = builder.dateOfMembership;
        this.totalBooksCheckedout = builder.totalBooksCheckedout;
    }

    public Date getDateOfMembership() {
        return dateOfMembership;
    }

    public int getTotalBooksCheckedout() {
        return totalBooksCheckedout;
    }

    public boolean reserveBookItem(BookItem bookItem) {
        return true;
    }

    private void incrementTotalBooksCheckedout() {
    }

    public boolean checkoutBookItem(BookItem bookItem) {
        return true;
    }

    private void checkForFine(String bookItemBarcode) {
    }

    public void returnBookItem(BookItem bookItem) {
    }

    public boolean renewBookItem(BookItem bookItem) {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " " +
                "Member{" +
                "dateOfMembership=" + dateOfMembership +
                ", totalBooksCheckedout=" + totalBooksCheckedout +
                '}';
    }
}
