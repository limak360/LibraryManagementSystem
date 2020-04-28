package pl.jackokamil.librarymanagementsystem.book;

import java.util.Date;

public class BookReservation {
    private Date creationDate;
    private ReservationStatus status;

    public BookReservation(Date creationDate, ReservationStatus status) {
        this.creationDate = creationDate;
        this.status = status;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public BookReservation fetchReservationDetails(){
       return null;
    }

    @Override
    public String toString() {
        return "BookReservation{" +
                "creationDate=" + creationDate +
                ", status=" + status +
                '}';
    }
}
