package com.kamiljacko.librarymanagementsystem.dto;

import javax.validation.constraints.NotEmpty;

public class LibraryCardDto {
    @NotEmpty
    private String cardHolderName;

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
}


