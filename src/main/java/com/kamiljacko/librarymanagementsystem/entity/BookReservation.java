package com.kamiljacko.librarymanagementsystem.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class BookReservation {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private Date creationDate;
    private ReservationStatus status;

    public BookReservation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}