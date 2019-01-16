package com.prus.library.shell;

import com.prus.library.dao.BookDao;
import com.prus.library.domain.Author;
import com.prus.library.domain.Book;
import com.prus.library.domain.Publisher;
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
    public void getAllBooks(){
        List<Book> list = dao.getAll();
        for(Book book: list){
            System.out.println(book);
        }
    }

    @ShellMethod("Get book by ID")
    public void getBookById(long id){
        System.out.println(dao.getById(id));
    }

    @ShellMethod("Get books by YEAR")
    public void getBookByYear(int year){
        List<Book> list = dao.getByYear(year);
        for(Book book: list){
            System.out.println(book);
        }
    }

    @ShellMethod("Get books by TYPE")
    public void getBookByType(String type){
        List<Book> list = dao.getByType(type);
        for(Book book: list){
            System.out.println(book);
        }
    }

    @ShellMethod("Get books by PUBLISHER")
    public void getBookByPublisher(String name){
        List<Book> list = dao.getByPublisher(name);
        for(Book book: list){
            System.out.println(book);
        }
    }

    @ShellMethod("Add book: NAME ISBN YEAR TYPE AUTHOR-FIRST-NAME AUTHOR-LAST-NAME PUBLISHER COUNTRY")
    public void addBook(String name, int isbn, int year, String type,
                        String authorFirstName, String authorLastName,
                        String publisher, String country){
        Book book = new Book(name, isbn, year, type,
                new Publisher(publisher, country),
                new Author(authorFirstName, authorLastName));
        dao.insert(book);
    }


}
