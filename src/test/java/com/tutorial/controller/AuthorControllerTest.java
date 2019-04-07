package com.tutorial.controller;

import com.tutorial.model.Author;
import com.tutorial.service.AuthorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith( SpringRunner.class )
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorService authorService;

    @Test
    public void test_AuthorByFirstName() throws Exception{
        BDDMockito.given( authorService.getAuthorByFirstName( ArgumentMatchers.anyString() ) )
                .willReturn( new Author( "Eric", "Evans" ) );

        mockMvc.perform( MockMvcRequestBuilders.get("/author/Eric") )
                .andDo( MockMvcResultHandlers.print() )
                .andExpect( MockMvcResultMatchers.status().isOk() )
                .andExpect( MockMvcResultMatchers.view().name( "authorByFirstName" ) )
                .andExpect( MockMvcResultMatchers.content().string( org.hamcrest.Matchers.containsString("Evans") ) );

    }
}