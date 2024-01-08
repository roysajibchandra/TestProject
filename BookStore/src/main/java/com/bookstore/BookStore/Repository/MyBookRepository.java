package com.bookstore.BookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.BookStore.Entities.MyBooksList;

@Repository
public interface MyBookRepository extends JpaRepository<MyBooksList, Integer>{
    
}
