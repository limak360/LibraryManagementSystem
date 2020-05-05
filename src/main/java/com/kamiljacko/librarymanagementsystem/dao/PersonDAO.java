package com.kamiljacko.librarymanagementsystem.dao;


import com.kamiljacko.librarymanagementsystem.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends JpaRepository<Person, Integer> {
}