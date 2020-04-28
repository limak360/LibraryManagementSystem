package pl.jackokamil.librarymanagementsystem.book;


import java.io.Serializable;

public class Author implements Serializable {

    private String name;
    private String description;

    public Author(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
