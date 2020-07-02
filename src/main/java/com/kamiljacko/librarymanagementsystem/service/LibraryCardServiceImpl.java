package com.kamiljacko.librarymanagementsystem.service;

import com.kamiljacko.librarymanagementsystem.dto.LibraryCardDto;
import com.kamiljacko.librarymanagementsystem.entity.LibraryCard;
import com.kamiljacko.librarymanagementsystem.repository.LibraryCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryCardServiceImpl implements LibraryCardService {

    private final LibraryCardRepository repository;

    @Autowired
    public LibraryCardServiceImpl(LibraryCardRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(LibraryCardDto libraryCard) {

        LibraryCard card = new LibraryCard();
        //

        repository.save(card);
    }
}
