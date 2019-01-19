package com.prus.library.shell;

import com.prus.library.dao.PublisherDao;
import com.prus.library.domain.Publisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;
import java.util.stream.Collectors;

@ShellComponent
public class PublisherCommands {

    private PublisherDao dao;

    public PublisherCommands(PublisherDao publisherDao){
        this.dao = publisherDao;
    }

    @ShellMethod("Add publisher: NAME COUNTRY")
    public void addPublisher(String name, String country){
        Publisher publisher = new Publisher(name, country);
        dao.insert(publisher);
    }

    @ShellMethod("Get all publishers")
    public String getAllPublishers(){
        return dao.getAll().stream().map(Publisher::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get publisher by ID")
    public String getPublisherById(long id){
        return dao.getById(id).toString();
    }

    @ShellMethod("Get publisher by NAME")
    public String getPublisherByName(String name){
        return dao.getByName(name).toString();
    }

    @ShellMethod("Get publisher by COUNTRY")
    public String getPublisherByCountry(String country){
        return dao.getByCountry(country).toString();
    }


}
