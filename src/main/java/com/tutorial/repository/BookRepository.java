package com.tutorial.repository;

import com.tutorial.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    Book findByTitle(String title);
}
