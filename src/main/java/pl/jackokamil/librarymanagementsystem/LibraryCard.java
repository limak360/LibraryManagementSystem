package pl.jackokamil.librarymanagementsystem;

import java.util.Date;

public class LibraryCard {
    private String cardNumber;
    private String barCode;
    private Date issuedAt;
    private boolean active;

    public LibraryCard(String cardNumber, String barCode, Date issuedAt, boolean active) {
        this.cardNumber = cardNumber;
        this.barCode = barCode;
        this.issuedAt = issuedAt;
        this.active = active;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getBarCode() {
        return barCode;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "LibraryCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", barCode='" + barCode + '\'' +
                ", issuedAt=" + issuedAt +
                ", active=" + active +
                '}';
    }
}
