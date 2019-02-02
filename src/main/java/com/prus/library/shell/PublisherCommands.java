package com.prus.library.shell;

import com.prus.library.entities.PublisherEntity;
import com.prus.library.services.PublisherService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
public class PublisherCommands {

    private PublisherService service;

    public PublisherCommands(PublisherService publisherService){
        this.service = publisherService;
    }

    @ShellMethod("Add publisher: NAME COUNTRY")
    public void addPublisher(String name, String country){
        PublisherEntity publisherEntity = new PublisherEntity();
        publisherEntity.setName(name);
        publisherEntity.setCountry(country);
        service.save(publisherEntity);
    }

    @ShellMethod("Get all publishers")
    public String getAllPublishers(){
        return service.findAll().stream().map(PublisherEntity::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get publisher by ID")
    public String getPublisherById(long id){
        return service.findByPublisherId(id).toString() ;
    }

    @ShellMethod("Get publisher by NAME")
    public String getPublisherByName(String name){
        return service.findByName(name).stream().map(PublisherEntity::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get publisher by COUNTRY")
    public String getPublisherByCountry(String country){
        return service.findByCountry(country).stream().map(PublisherEntity::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Delete publisher by ID")
    public void deleteByPublisherId(long id){
        service.deleteByPublisherId(id);
    }

}
