package com.example.mongo.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongo.entity.Book;

public interface BookRepository extends MongoRepository<Book,Long> {
    // Need to add all the required methods here
    List<Book> findByCategory(String category);
    Book findByBookId(long bookId);
}

