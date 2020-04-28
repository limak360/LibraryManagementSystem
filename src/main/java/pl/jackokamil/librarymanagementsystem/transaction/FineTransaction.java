package pl.jackokamil.librarymanagementsystem.transaction;

import java.util.Date;

public abstract class FineTransaction {
    private Date creationDate;
    private double amount;

    public FineTransaction(Date creationDate, double amount) {
        this.creationDate = creationDate;
        this.amount = amount;
    }

    public boolean initiateTransaction() {
        return false;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "FineTransaction{" +
                "creationDate=" + creationDate +
                ", amount=" + amount +
                '}';
    }
}
