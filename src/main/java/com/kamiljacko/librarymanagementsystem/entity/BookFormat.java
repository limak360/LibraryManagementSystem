package com.kamiljacko.librarymanagementsystem.entity;

public enum BookFormat {

    PAPERBACK("Paperback"),
    HARDCOVER("Hardcover"),
    EBOOK("Ebook"),
    AUDIOBOOK("Audiobook"),
    NEWSPAPER("Newspaper");

    private final String displayName;

    BookFormat(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
