package com.tutorial.model;

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
public class PublisherTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    public void test_PublisherIntegrationTest() throws Exception{
        // Arrange
        Publisher publisher = new Publisher("Harper Collins","London");
        testEntityManager.persistAndFlush( publisher );

        // Act
        Publisher foundPublisher = publisherRepository.findByName( publisher.getName() );

        // Assert
        assertThat( foundPublisher.getName() ).isEqualTo( publisher.getName() );
        assertThat( foundPublisher.getAddress() ).isEqualTo( publisher.getAddress() );
    }
}