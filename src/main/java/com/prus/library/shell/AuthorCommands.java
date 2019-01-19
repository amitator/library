package com.prus.library.shell;

import com.prus.library.dao.AuthorDao;
import com.prus.library.domain.Author;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;
import java.util.stream.Collectors;

@ShellComponent
public class AuthorCommands {

    private AuthorDao dao;

    public AuthorCommands(AuthorDao authorDao){
        this.dao = authorDao;
    }

    @ShellMethod("Add author: FIRST_NAME LAST_NAME")
    public void addAuthor(String firstName, String lastName){
        Author author = new Author(firstName, lastName);
        dao.insert(author);
    }

    @ShellMethod("Get all authors")
    public String getAllAuthors(){
        return dao.getAll().stream().map(Author::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get author by ID")
    public String getAuthorById(long id){
        return dao.getById(id).toString();
    }

    @ShellMethod("Get authors by FIRST NAME")
    public String getAuthorsByFirstName(String firstName){
        return dao.getByFirstName(firstName).stream().map(Author::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get authors by LAST NAME")
    public String getAuthorsByLastName(String lastName){
        return dao.getByLastName(lastName).stream().map(Author::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get authors by FIRSTNAME LASTNAME")
    public String getAuthorByFullName(String firstName, String lastName){
        return dao.getByFullName(firstName, lastName).toString();
    }

}
