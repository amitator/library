package com.prus.library.dao;

import com.prus.library.entities.Author;
import com.prus.library.entities.Book;

import java.util.List;

public interface BookDao {

    void insert(Book book);

    Book getById(long id);

    List<Book> getByYear(int year);

    List<Book> getByType(String type);

    List<Book> getByAuthor(Author author);

    List<Book> getByPublisher(String name);

    List<Book> getAll();
}
