package com.example.jpademo.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpademo.database.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{}
