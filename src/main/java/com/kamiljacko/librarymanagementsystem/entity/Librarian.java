package com.kamiljacko.librarymanagementsystem.entity;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Librarian
        extends Account implements Serializable {

    public Librarian() {
    }
}