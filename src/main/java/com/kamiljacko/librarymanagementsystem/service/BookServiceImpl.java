package com.kamiljacko.librarymanagementsystem.service;

import com.kamiljacko.librarymanagementsystem.dto.BookDto;
import com.kamiljacko.librarymanagementsystem.entity.Author;
import com.kamiljacko.librarymanagementsystem.entity.BookItem;
import com.kamiljacko.librarymanagementsystem.repository.BookIemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookIemRepository bookIemRepository;

    @Autowired
    public BookServiceImpl(BookIemRepository bookIemRepository) {
        this.bookIemRepository = bookIemRepository;
    }

    @Override
    public void save(BookDto bookDto) {

        List<Author> authorList = new ArrayList<>();
        authorList.add(new Author());

        BookItem bookItem = new BookItem();
        bookItem.setISBN(bookDto.getISBN());
        bookItem.setTitle(bookDto.getTitle());
        bookItem.setSubject(bookDto.getSubject());
        bookItem.setPublisher(bookDto.getPublisher());
        bookItem.setLanguage(bookDto.getLanguage());
        bookItem.setNumberOfPages(bookDto.getNumberOfPages());
        bookItem.setAuthors(authorList); //bookDto.getAuthors()
        bookItem.setBookFormat(bookDto.getBookFormat());
        bookItem.setBookStatus(bookDto.getBookStatus());
        bookItem.setPublicationDate(bookDto.getPublicationDate());

        bookIemRepository.save(bookItem);
    }

    @Override
    public List<BookItem> findAll() {
        return bookIemRepository.findAll();
    }

    @Override
    public List<BookItem> findByTitle(String title) {
        return bookIemRepository.findByTitle(title);
    }
}