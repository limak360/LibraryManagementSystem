package pl.jackokamil.librarymanagementsystem.book;

import java.util.Date;

public class BookLending {
    private Date creationDate;
    private Date dueDate;
    private Date returnDate;

    public BookLending(Date creationDate, Date dueDate, Date returnDate) {
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return "BookLending{" +
                "creationDate=" + creationDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
