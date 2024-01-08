package com.bookstore.BookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.BookStore.Entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

    
} 