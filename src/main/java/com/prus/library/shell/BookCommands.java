package com.prus.library.shell;

import com.prus.library.entities.AuthorEntity;
import com.prus.library.entities.BookEntity;
import com.prus.library.entities.PublisherEntity;
import com.prus.library.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@ShellComponent
public class BookCommands {

    private BookService service;

    @ShellMethod("Get all books")
    public String getAllBooks(){
        return service.getAll().stream().map(BookEntity::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get book by ID")
    public String getBookById(long id){
        return service.getById(id).toString();
    }

    @ShellMethod("Get books by PUBLISHER_ID")
    public String getBookByPublisherId(Long id){
        return service.getByPublisherId(id).stream().map(BookEntity::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Get books by AUTHOR_ID")
    public String getBookByAuthorId(Long id){
        return service.getByAuthorId(id).stream().map(BookEntity::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Add book: NAME ISBN YEAR TYPE AUTHOR-FIRST-NAME AUTHOR-LAST-NAME PUBLISHER COUNTRY")
    public void addBook(String name, int isbn, int year, String type,
                        String authorFirstName, String authorLastName,
                        String publisher, String country){
        BookEntity bookEntity = new BookEntity(name, isbn, year, type,
                new PublisherEntity(publisher, country),
                new AuthorEntity(authorFirstName, authorLastName));
        service.insert(bookEntity);
    }

    @ShellMethod("Delete book by ID")
    public String deleteBookById(Long id){
        service.deleteById(id);
        return "Book with ID: " + id + " deleted.";
    }

}
