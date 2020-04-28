package pl.jackokamil.librarymanagementsystem.transaction;

import java.util.Date;

public class CashTransaction extends FineTransaction {
    public CashTransaction(Date creationDate, double amount) {
        super(creationDate, amount);
    }
    //
}
