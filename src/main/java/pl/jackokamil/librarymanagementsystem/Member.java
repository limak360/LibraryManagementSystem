package pl.jackokamil.librarymanagementsystem;

import pl.jackokamil.librarymanagementsystem.enums.AccountStatus;

import java.util.Date;

public class Member
        extends Account {

    private Date dateOfMembership;
    private int totalBooksCheckedout;

    public Member(int id, String password, AccountStatus status, Person person, Date dateOfMembership, int totalBooksCheckedout) {
        super(id, password, status, person);
        this.dateOfMembership = dateOfMembership;
        this.totalBooksCheckedout = totalBooksCheckedout;
    }

    public Date getDateOfMembership() {
        return dateOfMembership;
    }

    public int getTotalBooksCheckedout() {

        return totalBooksCheckedout;
    }

    public boolean resetPassword() {
        return false;
    }
}
