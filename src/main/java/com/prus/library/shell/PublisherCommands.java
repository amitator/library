package com.prus.library.shell;

import com.prus.library.entities.PublisherEntity;
import com.prus.library.services.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@ShellComponent
public class PublisherCommands {

    private PublisherService service;

    @ShellMethod("Add publisher: NAME COUNTRY")
    public void addPublisher(String name, String country){
        PublisherEntity publisherEntity = new PublisherEntity();
        publisherEntity.setName(name);
        publisherEntity.setCountry(country);
        service.insert(publisherEntity);
    }

    @ShellMethod("Get all publishers")
    public String getAllPublishers(){
        return service.getAll().stream().map(PublisherEntity::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get publisher by ID")
    public String getPublisherById(long id){
        return service.findByPublisherId(id).toString() ;
    }

    @ShellMethod("Delete publisher by ID")
    public void deleteByPublisherId(long id){
        service.deleteByPublisherId(id);
    }

}
