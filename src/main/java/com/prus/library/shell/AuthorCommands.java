package com.prus.library.shell;

import com.prus.library.entities.AuthorEntity;
import com.prus.library.services.AuthorService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
public class AuthorCommands {

//    private AuthorDao dao;

    private AuthorService service;


    public AuthorCommands(AuthorService authorService){
        this.service = authorService;
    }

    @ShellMethod("Add author: FIRST_NAME LAST_NAME")
    public void addAuthor(String firstName, String lastName){
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setFirstName(firstName);
        authorEntity.setLastName(lastName);
        service.save(authorEntity);
    }

    @ShellMethod("Get all authors")
    public String getAllAuthors() {
        return service.findAll().stream().map(AuthorEntity::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get author by ID")
    public String getAuthorById(long id) {
        return service.getByAuthorId(id).toString();
    }

    @ShellMethod("Get authors by FIRST NAME")
    public String getAuthorsByFirstName(String firstName) {
        return service.findByFirstName(firstName).stream().map(AuthorEntity::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get authors by LAST NAME")
    public String getAuthorsByLastName(String lastName) {
        return service.findByLastName(lastName).stream().map(AuthorEntity::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get authors by FIRSTNAME LASTNAME")
    public String getAuthorByFullName(String firstName, String lastName) {
        return service.findByFirstNameAndLastName(firstName, lastName).toString();
    }

    @ShellMethod("Delete author by ID")
    public void deleteAuthorById(long id) {
        service.deleteByAuthorId(id);
    }
}