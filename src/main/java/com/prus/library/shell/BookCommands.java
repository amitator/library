package com.prus.library.shell;

import com.prus.library.dao.BookDao;
import com.prus.library.domain.Book;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class BookCommands {

    private BookDao dao;

    public BookCommands(BookDao bookDao){
        dao = bookDao;
    }

    @ShellMethod("Get all books")
    public void getAll(){
        List<Book> list = dao.getAll();
        for(Book book: list){
            System.out.println(book);
        }
    }

    @ShellMethod("Get book by ID")
    public void getId(long id){
        System.out.println(dao.getById(id));
    }

    @ShellMethod("Get books by YEAR")
    public void getYear(int year){
        List<Book> list = dao.getByYear(year);
        for(Book book: list){
            System.out.println(book);
        }
    }

    @ShellMethod("Get books by TYPE")
    public void getType(String type){
        List<Book> list = dao.getByType(type);
        for(Book book: list){
            System.out.println(book);
        }
    }

    @ShellMethod("Add book: NAME ISBN YEAR TYPE PUBLISHER_ID AUTHOR_ID")
    public void add(String name, int isbn, int year, String type, int publisher_id, int author_id){
        Book book = new Book(name, isbn, year, type, publisher_id, author_id);
        dao.insert(book);
    }


}
