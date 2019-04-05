package com.tutorial.model;

import com.tutorial.repository.AuthorRepository;
import com.tutorial.repository.BookRepository;
import com.tutorial.repository.PublisherRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;


@RunWith( SpringRunner.class )
@DataJpaTest
public class BookTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    public void test_BookRepositoryIntegrationTest() throws Exception{
        // Arrange
        Publisher publisher = new Publisher("Harper Collins","London");
        testEntityManager.persistAndFlush( publisher );

        Book book = new Book( "Domain Driven Design","1234", publisher );
        testEntityManager.persistAndFlush( book );

        // Act
        Book foundBook = bookRepository.findByTitle( book.getTitle() );
        // Assert
        assertThat( foundBook.getTitle() ).isEqualTo( book.getTitle() );
    }
}