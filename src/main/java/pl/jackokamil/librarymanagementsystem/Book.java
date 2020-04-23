package pl.jackokamil.librarymanagementsystem;

import java.util.List;

public abstract class Book {
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private List<Author> authors;

    protected abstract static class Builder<T extends Builder<T>> {

        private String ISBN;
        private String title;
        private String subject;
        private String publisher;
        private String language;
        private int numberOfPages;
        private List<Author> authors;

        public Builder<T> ISBN(String ISBN) {
            this.ISBN = ISBN;
            return this;
        }

        public Builder<T> title(String title) {
            this.title = title;
            return this;
        }

        public Builder<T> subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder<T> publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder<T> language(String language) {
            this.language = language;
            return this;
        }

        public Builder<T> numberOfPages(int numberOfPages) {
            this.numberOfPages = numberOfPages;
            return this;
        }

        public Builder<T> authors(List<Author> authors) {
            this.authors = authors;
            return this;
        }

        abstract Book build();

        protected abstract T self();
    }

    Book(Builder<?> builder) {
        this.ISBN = builder.ISBN;
        this.title = builder.title;
        this.subject = builder.subject;
        this.publisher = builder.publisher;
        this.language = builder.language;
        this.numberOfPages = builder.numberOfPages;
        this.authors = builder.authors;
    }
}

