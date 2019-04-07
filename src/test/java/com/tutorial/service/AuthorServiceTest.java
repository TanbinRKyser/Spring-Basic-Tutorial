package com.tutorial.service;

import com.tutorial.model.Author;
import com.tutorial.repository.AuthorRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith( MockitoJUnitRunner.class )
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;
    private AuthorService authorService;

    @Before
    public void setUp() throws Exception{
        authorService = new AuthorService( authorRepository );
    }

    @Test
    public void test_findByAuthorFirstName() throws Exception{
        given( authorRepository.findByFirstName( "Eric" ) )
                .willReturn( new Author( "Eric","Evans" ) );

        Author foundAuthor = authorService.getAuthorByFirstName( "Eric" );

        assertThat( foundAuthor.getFirstName() ).isEqualTo( "Eric" );
        assertThat( foundAuthor.getLastName() ).isEqualTo( "Evans" );
    }
}