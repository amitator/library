package com.prus.library.shell;

import com.prus.library.entities.AuthorEntity;
import com.prus.library.entities.BookEntity;
import com.prus.library.entities.PublisherEntity;
import com.prus.library.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Locale;
import java.util.stream.Collectors;

@AllArgsConstructor
@ShellComponent
public class BookCommands {

    private BookService service;

    @ShellMethod("Get all books")
    public String getAllBooks(){
        return service.findAll().stream().map(BookEntity::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get book by ID")
    public String getBookByName(String name){
        return service.findByName(name).toString();
    }

    @ShellMethod("Get book by ID")
    public String getBookById(long id){
        return service.findById(id).toString();
    }

    @ShellMethod("Get books by YEAR")
    public String getBookByYear(int year){
        return service.findByYear(year).stream().map(BookEntity::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get books by TYPE")
    public String getBookByType(String type){
        return service.findByType(type).stream().map(BookEntity::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get books by PUBLISHER_ID")
    public String getBookByPublisherId(Long id){
        return service.findByPublisherEntityPublisherId(id).stream().map(BookEntity::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get books by AUTHOR_ID")
    public String getBookByAuthorId(Long id){
        return service.findByAuthorEntityAuthorId(id).stream().map(BookEntity::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Add book: NAME ISBN YEAR TYPE AUTHOR-FIRST-NAME AUTHOR-LAST-NAME PUBLISHER COUNTRY")
    public void addBook(String name, int isbn, int year, String type,
                        String authorFirstName, String authorLastName,
                        String publisher, String country){
        BookEntity bookEntity = new BookEntity(name, isbn, year, type,
                new PublisherEntity(publisher, country),
                new AuthorEntity(authorFirstName, authorLastName));
        service.save(bookEntity);
    }


}
