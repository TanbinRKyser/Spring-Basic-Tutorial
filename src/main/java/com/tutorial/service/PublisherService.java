package com.tutorial.service;

import com.tutorial.model.Publisher;
import com.tutorial.repository.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    private PublisherRepository publisherRepository;

    public PublisherService( PublisherRepository publisherRepository ) {
        this.publisherRepository = publisherRepository;
    }

    public Iterable<Publisher> findByName( String name ){
        Iterable<Publisher> publishers = publisherRepository.findAll();
        if( publishers == null ){
            throw new RuntimeException( "Publisher Not found" );
        }

        return publishers;
    }
}
