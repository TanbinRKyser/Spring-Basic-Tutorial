package com.tutorial.service;

import com.tutorial.model.Author;
import com.tutorial.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService( AuthorRepository authorRepository ) {
        this.authorRepository = authorRepository;
    }

    public Iterable<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorByFirstName(String name){
        Author author = authorRepository.findByFirstName( name );
        if( author == null ){
            throw new RuntimeException( "Author Not Found" );
        }
        return author;
    }
}
