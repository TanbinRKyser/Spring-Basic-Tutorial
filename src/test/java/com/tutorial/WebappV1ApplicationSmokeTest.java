package com.tutorial;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.controller.AuthorController;
import com.tutorial.controller.BookController;
import com.tutorial.model.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Smoke Test
 */

@RunWith( SpringRunner.class )
@SpringBootTest
public class WebappV1ApplicationSmokeTest {

    @Autowired
    private AuthorController authorController;
    @Autowired
    private BookController bookController;


    @Test
    public void contextLoads() throws Exception{
        assertThat( authorController ).isNotNull();
        assertThat( bookController ).isNotNull();
    }

}
