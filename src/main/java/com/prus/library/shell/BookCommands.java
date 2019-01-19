package com.prus.library.shell;

import com.prus.library.dao.BookDao;
import com.prus.library.domain.Author;
import com.prus.library.domain.Book;
import com.prus.library.domain.Publisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

@ShellComponent
public class BookCommands {

    private BookDao dao;

    public BookCommands(BookDao bookDao){
        dao = bookDao;
    }

    @ShellMethod("Get all books")
    public String getAllBooks(){
        return dao.getAll().stream().map(Book::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get book by ID")
    public String getBookById(long id){
        return dao.getById(id).toString();
    }

    @ShellMethod("Get books by YEAR")
    public String getBookByYear(int year){
        return dao.getByYear(year).stream().map(Book::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get books by TYPE")
    public String getBookByType(String type){
        return dao.getByType(type).stream().map(Book::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get books by PUBLISHER")
    public String getBookByPublisher(String name){
        return dao.getByPublisher(name).stream().map(Book::toString).collect(Collectors.joining("\n"));
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
