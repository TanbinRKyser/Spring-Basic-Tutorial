package com.tutorial.bootstrap;

import com.tutorial.model.Author;
import com.tutorial.model.Book;
import com.tutorial.model.Publisher;
import com.tutorial.repository.AuthorRepository;
import com.tutorial.repository.BookRepository;
import com.tutorial.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public DevBootstrap( AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent( ContextRefreshedEvent event ) {
        initData();
    }

    private void initData(){
        // Harper Collins
        Publisher publisher = new Publisher("Harper Collins","London");

        publisherRepository.save( publisher );

        // Worx
        Publisher publisher2 = new Publisher("Worx", "New York");

        publisherRepository.save( publisher2 );


        // Eric
        Author eric = new Author( "Eric", "Evans" );
        Book ddd = new Book( "Domain Driven Design", "1234", publisher );
        eric.getBooks().add( ddd );
        ddd.getAuthors().add( eric );

        authorRepository.save( eric );
        bookRepository.save( ddd );

        // Rod
        Author rod = new Author( "Rod", "Johnson" );
        Book noEJB = new Book( "J2EE development without EJB", "2345", publisher2 );
        rod.getBooks().add( noEJB );
        //noEJB.getAuthors().add( rod );

        authorRepository.save( rod );
        bookRepository.save( noEJB );
    }
}
