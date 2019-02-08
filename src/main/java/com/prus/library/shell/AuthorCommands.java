package com.prus.library.shell;

import com.prus.library.entities.AuthorEntity;
import com.prus.library.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@AllArgsConstructor
@ShellComponent
public class AuthorCommands {

    private AuthorService service;

    @ShellMethod("Add author: FIRST_NAME LAST_NAME")
    public void addAuthor(String firstName, String lastName){
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setFirstName(firstName);
        authorEntity.setLastName(lastName);
        service.insert(authorEntity);
    }

    @ShellMethod("Get all authors")
    public String getAllAuthors() {
        return service.getAll().stream().map(AuthorEntity::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get author by ID")
    public String getAuthorById(long id) {
        return service.getByAuthorId(id).toString();
    }

    @ShellMethod("Delete author by ID")
    public void deleteAuthorById(long id) {
        service.deleteByAuthorId(id);
    }
}