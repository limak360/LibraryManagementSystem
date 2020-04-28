package pl.jackokamil.librarymanagementsystem.transaction;

import java.util.Date;

public class CreditCardTransaction extends FineTransaction{
    public CreditCardTransaction(Date creationDate, double amount) {
        super(creationDate, amount);
    }
    //
}
