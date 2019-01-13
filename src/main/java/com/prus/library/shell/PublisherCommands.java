package com.prus.library.shell;

import com.prus.library.dao.PublisherDao;
import com.prus.library.domain.Publisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class PublisherCommands {

    private PublisherDao dao;

    public PublisherCommands(PublisherDao publisherDao){
        this.dao = publisherDao;
    }

    @ShellMethod("Add publisher: NAME COUNTRY")
    public void addpub(String name, String country){
        Publisher publisher = new Publisher(name, country);
        dao.insert(publisher);
    }

    @ShellMethod("Get all publishers")
    public void getpubAll(){
        List<Publisher> list = dao.getAll();
        for(Publisher publisher: list){
            System.out.println(publisher);
        }
    }

    @ShellMethod("Get publisher by ID")
    public void getpubId(long id){
        System.out.println(dao.getById(id));
    }

    @ShellMethod("Get authors by FIRST NAME")
    public void getpubName(String name){
        List<Publisher> list = dao.getByName(name);
        for(Publisher publisher: list){
            System.out.println(publisher);
        }
    }

    @ShellMethod("Get authors by COUNTRY")
    public void getpubCountry(String country){
        List<Publisher> list = dao.getByCountry(country);
        for(Publisher publisher: list){
            System.out.println(publisher);
        }
    }


}
