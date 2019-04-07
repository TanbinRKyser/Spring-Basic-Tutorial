package com.tutorial.service;

import com.tutorial.model.Book;
import com.tutorial.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService( BookRepository bookRepository ) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    Book findByBookTitle( String title ) {
        Book book = bookRepository.findByTitle( title );
        if( book == null ){
            throw new RuntimeException( "Book not found" );
        }
        return book;
    }
}
