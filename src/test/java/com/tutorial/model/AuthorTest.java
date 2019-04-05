package com.tutorial.model;

import com.tutorial.repository.AuthorRepository;
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
public class AuthorTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void test_AuthorRepositoryIntegrationTest() throws Exception{
        // Arrange
        Author author = new Author("Chris","Evans");
        testEntityManager.persistAndFlush( author );
        // Act
        Author foundAuthor = authorRepository.findByFirstName(author.getFirstName());
        // Assert
        assertThat( foundAuthor.getFirstName() ).isEqualTo( author.getFirstName() );
        assertThat( foundAuthor.getLastName() ).isEqualTo( author.getLastName() );
    }
}