package com.prus.library.shell;

import com.prus.library.dao.BookDao;
import com.prus.library.domain.Book;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class LibraryCommand {

    private BookDao dao;

    public LibraryCommand(BookDao bookDao){
        dao = bookDao;
    }

    @ShellMethod("Get all records")
    public void getAll(){
        List<Book> list = dao.getAll();
        for(Book book: list){
            System.out.println(book);
        }
    }

    @ShellMethod("Get reccord by ID")
    public void getById(int id){
        System.out.println(dao.getById(id));
    }

    @ShellMethod("Get reccord by YEAR")
    public void getByYear(int year){
        List<Book> list = dao.getByYear(year);
        for(Book book: list){
            System.out.println(book);
        }
    }

    @ShellMethod("Get reccord by TYPE")
    public void getByType(String type){
        List<Book> list = dao.getByType(type);
        for(Book book: list){
            System.out.println(book);
        }
    }

}
