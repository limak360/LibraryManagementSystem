package com.kamiljacko.librarymanagementsystem.dao;


import com.kamiljacko.librarymanagementsystem.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO extends JpaRepository<Member, Integer> {
}