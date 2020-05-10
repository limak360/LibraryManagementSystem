package com.kamiljacko.librarymanagementsystem.entity;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Member
        extends Account implements Serializable {

    private Date dateOfMembership;
    private int totalBooksCheckedout;

    public Member() {
    }

    public Date getDateOfMembership() {
        return dateOfMembership;
    }

    public void setDateOfMembership(Date dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public int getTotalBooksCheckedout() {
        return totalBooksCheckedout;
    }

    public void setTotalBooksCheckedout(int totalBooksCheckedout) {
        this.totalBooksCheckedout = totalBooksCheckedout;
    }
}