package pl.jackokamil.librarymanagementsystem;

import pl.jackokamil.librarymanagementsystem.enums.BookFormat;
import pl.jackokamil.librarymanagementsystem.enums.BookStatus;

import java.util.Date;

public class BookItem
        extends Book {
    private String barCode;
    private BookFormat bookFormat;
    private BookStatus bookStatus;
    private double price;
    private Date borrowed;
    private Date dueDate;
    private Date dateOfPurchase;
    private Date publicationDate;

    public static class Builder
            extends Book.BaseBuilder<Builder> {
        private String barCode;
        private BookFormat bookFormat;
        private BookStatus bookStatus;
        private double price;
        private Date borrowed;
        private Date dueDate;
        private Date dateOfPurchase;
        private Date publicationDate;

        public Builder barCode(String barCode) {
            this.barCode = barCode;
            return this;
        }

        public Builder bookFormat(BookFormat bookFormat) {
            this.bookFormat = bookFormat;
            return this;
        }

        public Builder bookStatus(BookStatus bookStatus) {
            this.bookStatus = bookStatus;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder borrowed(Date borrowed) {
            this.borrowed = borrowed;
            return this;
        }

        public Builder dueDate(Date dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder dateOfPurchase(Date dateOfPurchase) {
            this.dateOfPurchase = dateOfPurchase;
            return this;
        }

        public Builder publicationDate(Date publicationDate) {
            this.publicationDate = publicationDate;
            return this;
        }

        @Override
        Book build() {
            return new BookItem(self());
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    BookItem(Builder builder) {
        super(builder);
        this.barCode = builder.barCode;
        this.bookFormat = builder.bookFormat;
        this.bookStatus = builder.bookStatus;
        this.price = builder.price;
        this.borrowed = builder.borrowed;
        this.dueDate = builder.dueDate;
        this.dateOfPurchase = builder.dateOfPurchase;
        this.publicationDate = builder.publicationDate;
    }

    public String getBarCode() {
        return barCode;
    }

    public BookFormat getBookFormat() {
        return bookFormat;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public double getPrice() {
        return price;
    }

    public Date getBorrowed() {
        return borrowed;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    @Override
    public String toString() {
        return super.toString() + " " +
                "BookItem{" +
                "barCode='" + barCode + '\'' +
                ", bookFormat=" + bookFormat +
                ", bookStatus=" + bookStatus +
                ", price=" + price +
                ", borrowed=" + borrowed +
                ", dueDate=" + dueDate +
                ", dateOfPurchase=" + dateOfPurchase +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
