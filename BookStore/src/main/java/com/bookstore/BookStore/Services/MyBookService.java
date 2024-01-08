package com.bookstore.BookStore.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.BookStore.Entities.MyBooksList;
import com.bookstore.BookStore.Repository.MyBookRepository;
import java.util.*;

@Service
public class MyBookService {
    @Autowired
    private MyBookRepository myBookRepository;

    public void saveMyBooksList(MyBooksList myBooksList){
        myBookRepository.save(myBooksList);
    }
    public List<MyBooksList> getAllMyBooks(){
        return myBookRepository.findAll();
    } 

    public void deleteById(int id){
        myBookRepository.deleteById(id);
    }
}
