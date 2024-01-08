package com.bookstore.BookStore.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mybooks")
public class MyBooksList {
    @Id
    @Column(name = "book_id")
    private int id;
    private String name;
    private String author;
    private String price;
}
