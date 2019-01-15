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

    @ShellMethod("Add book: NAME ISBN YEAR TYPE PUBLISHER_ID AUTHOR_ID")
    public void addBook(String name, int isbn, int year, String type, int publisher_id, int author_id){
        Book book = new Book(name, isbn, year, type, publisher_id, author_id);
        dao.insert(book);
    }


}
