package pl.jackokamil.librarymanagementsystem;

import pl.jackokamil.librarymanagementsystem.enums.AccountStatus;

import java.util.Date;

public class Member
        extends Account {

    private Date dateOfMembership;
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
        Account build() {
            return new Member(self());
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

    @Override
    public String toString() {
        return super.toString() + " " +
                "Member{" +
                "dateOfMembership=" + dateOfMembership +
                ", totalBooksCheckedout=" + totalBooksCheckedout +
                '}';
    }
}
