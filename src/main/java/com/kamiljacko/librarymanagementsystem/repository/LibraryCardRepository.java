package com.kamiljacko.librarymanagementsystem.repository;

import com.kamiljacko.librarymanagementsystem.entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard, Integer> {
}
