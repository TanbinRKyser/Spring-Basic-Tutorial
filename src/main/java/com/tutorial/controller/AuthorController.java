package com.tutorial.controller;

import com.tutorial.model.Author;
import com.tutorial.repository.AuthorRepository;
import com.tutorial.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private static Logger LOGGER = LoggerFactory.getLogger( AuthorController.class );

    private final AuthorService authorService;

    public AuthorController( AuthorService authorService ) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    public String getAuthors( Model model){
        model.addAttribute( "authors", authorService.getAllAuthors() );

        return "authors";
    }

    @RequestMapping("/author/{name}")
    String getAllAuthors( Model model, @PathVariable String name ){
        // LOGGER.info( "{}",name );
        Author author = authorService.getAuthorByFirstName( name );
        // LOGGER.info( "{}", author.getFirstName() );
        // LOGGER.info( "{}",author.getBooks() );
        model.addAttribute( "firstName",author.getFirstName() );
        model.addAttribute( "lastName",author.getLastName() );

        return "authorByFirstName";
    }


}
