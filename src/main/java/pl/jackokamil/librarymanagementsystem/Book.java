package pl.jackokamil.librarymanagementsystem;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public abstract class Book {
    @NotNull
    private String ISBN;
    @NotNull
    private String title;
    @NotNull
    private String subject;
    @NotNull
    private String publisher;
    @NotNull
    private String language;
    @NotNull
    private int numberOfPages;
    @NotNull
    private List<Author> authors;

    protected abstract static class BaseBuilder<T extends BaseBuilder<T>> {
        private String ISBN;
        private String title;
        private String subject;
        private String publisher;
        private String language;
        private int numberOfPages;
        private List<Author> authors = new ArrayList<>();

        public T ISBN(String ISBN) {
            this.ISBN = ISBN;
            return self();
        }

        public T title(String title) {
            this.title = title;
            return self();
        }

        public T subject(String subject) {
            this.subject = subject;
            return self();
        }

        public T publisher(String publisher) {
            this.publisher = publisher;
            return self();
        }

        public T language(String language) {
            this.language = language;
            return self();
        }

        public T numberOfPages(int numberOfPages) {
            this.numberOfPages = numberOfPages;
            return self();
        }

        public T addAuthor(Author author) {
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

