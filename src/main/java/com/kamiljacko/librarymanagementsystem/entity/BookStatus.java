package com.kamiljacko.librarymanagementsystem.entity;

public enum BookStatus {

    AVAILABLE("Available"),
    RESERVED("Reserved"),
    LOST("Lost"),
    LOANED("Loaned");

    private final String displayName;

    BookStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
