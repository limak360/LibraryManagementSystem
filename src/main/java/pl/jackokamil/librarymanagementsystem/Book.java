package pl.jackokamil.librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public abstract class Book {
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private List<Author> authors;

    protected abstract static class BaseBuilder<T extends BaseBuilder<T>> {
        private String ISBN;
        private String title;
        private String subject;
        private String publisher;
        private String language;
        private int numberOfPages;
        private List<Author> authors = new ArrayList<>();

        public BaseBuilder<T> ISBN(String ISBN) {
            this.ISBN = ISBN;
            return self();
        }

        public BaseBuilder<T> title(String title) {
            this.title = title;
            return self();
        }

        public BaseBuilder<T> subject(String subject) {
            this.subject = subject;
            return self();
        }

        public BaseBuilder<T> publisher(String publisher) {
            this.publisher = publisher;
            return self();
        }

        public BaseBuilder<T> language(String language) {
            this.language = language;
            return self();
        }

        public BaseBuilder<T> numberOfPages(int numberOfPages) {
            this.numberOfPages = numberOfPages;
            return self();
        }

        public BaseBuilder<T> addAuthor(Author author) {
            this.authors.add(author);
            return self();
        }

        abstract Book build();

        protected abstract T self();
    }

    Book(BaseBuilder<?> builder) {
        this.ISBN = builder.ISBN;
        this.title = builder.title;
        this.subject = builder.subject;
        this.publisher = builder.publisher;
        this.language = builder.language;
        this.numberOfPages = builder.numberOfPages;
        this.authors = builder.authors;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getLanguage() {
        return language;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", publisher='" + publisher + '\'' +
                ", language='" + language + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", authors=" + authors +
                '}';
    }
}

