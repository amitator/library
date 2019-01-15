package com.prus.library.shell;

import com.prus.library.dao.AuthorDao;
import com.prus.library.domain.Author;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class AuthorCommands {

    private AuthorDao dao;

    public AuthorCommands(AuthorDao authorDao){
        this.dao = authorDao;
    }

    @ShellMethod("Add author: FIRST_NAME LAST_NAME")
    public void addAuthor(String first_name, String last_name){
        Author author = new Author(first_name, last_name);
        dao.insert(author);
    }

    @ShellMethod("Get all authors")
    public void getAllAuthors(){
        List<Author> list = dao.getAll();
        for(Author author: list){
            System.out.println(author);
        }
    }

    @ShellMethod("Get author by ID")
    public void getAuthorById(long id){
        System.out.println(dao.getById(id));
    }

    @ShellMethod("Get authors by FIRST NAME")
    public void getAuthorsByFirstName(String firstName){
        List<Author> list = dao.getByFirstName(firstName);
        for(Author author: list){
            System.out.println(author);
        }
    }

    @ShellMethod("Get authors by LAST NAME")
    public void getAuthorsByLastName(String lastName){
        List<Author> list = dao.getByLastName(lastName);
        for(Author author: list){
            System.out.println(author);
        }
    }

}
