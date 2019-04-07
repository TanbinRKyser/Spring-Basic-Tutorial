package com.tutorial.service;

import com.tutorial.model.Book;
import com.tutorial.model.Publisher;
import com.tutorial.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith( MockitoJUnitRunner.class )
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;
    private BookService bookService;

    @Before
    public void setUp() throws Exception{
        bookService = new BookService( bookRepository );
    }

    @Test
    public void test_findByBookTitle() throws Exception {
        Publisher publisher = new Publisher( "Harper Collins", "London" );

        BDDMockito.given( bookRepository.findByTitle( "Domain Driven Design" ) )
                .willReturn( new Book( "Domain Driven Design","123", publisher ) );

        Book foundBook = bookService.findByBookTitle( "Domain Driven Design" );

        Assertions.assertThat( foundBook.getTitle() ).isEqualTo( "Domain Driven Design" );
    }

}