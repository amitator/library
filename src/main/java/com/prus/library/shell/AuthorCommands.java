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

    @ShellMethod("Add author: ID FIRST_NAME LAST_NAME")
    public void addau(int id, String first_name, String last_name){
        Author author = new Author(id, first_name, last_name);
        dao.insert(author);
    }

    @ShellMethod("Get all authors")
    public void getauAll(){
        List<Author> list = dao.getAll();
        for(Author author: list){
            System.out.println(author);
        }
    }

    @ShellMethod("Get author by ID")
    public void getauId(int id){
        System.out.println(dao.getById(id));
    }

    @ShellMethod("Get authors by FIRST NAME")
    public void getauFirst(String firstName){
        List<Author> list = dao.getByFirstName(firstName);
        for(Author author: list){
            System.out.println(author);
        }
    }

    @ShellMethod("Get authors by LAST NAME")
    public void getauLast(String lastName){
        List<Author> list = dao.getByLastName(lastName);
        for(Author author: list){
            System.out.println(author);
        }
    }

}
