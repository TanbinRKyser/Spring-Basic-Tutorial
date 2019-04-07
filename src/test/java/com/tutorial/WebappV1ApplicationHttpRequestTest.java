package com.tutorial;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@RunWith( SpringRunner.class )
@SpringBootTest( webEnvironment = RANDOM_PORT )
public class WebappV1ApplicationHttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void test_HttpRequest() throws Exception {
        // Arrange
        ResponseEntity<String> authorResponseEntity = testRestTemplate.getForEntity( "/authors", String.class );
//        String authorObject = this.testRestTemplate.getForObject( "http://localhost:" + port + "/authors", String.class );
        ResponseEntity<String> bookResponseEntity = testRestTemplate.getForEntity( "/books", String.class );
//        String bookObject = this.testRestTemplate.getForObject( "http://localhost:" + port + "/books", String.class );
        // Act

        // Assert
        assertThat( authorResponseEntity.getStatusCode() ).isEqualTo( HttpStatus.OK );
//        assertThat( authorObject ).contains( "Eric" );
        assertThat( bookResponseEntity.getStatusCode() ).isEqualTo( HttpStatus.OK );
//        assertThat( bookObject ).contains( "Domain Driven Design" );
    }
}

