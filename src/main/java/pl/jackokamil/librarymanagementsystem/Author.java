package pl.jackokamil.librarymanagementsystem;

import javax.validation.constraints.NotNull;

public class Author {
    @NotNull
    private String name;
    @NotNull
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
