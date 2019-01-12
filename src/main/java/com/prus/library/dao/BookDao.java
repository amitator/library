package com.prus.library.dao;

import com.prus.library.domain.Author;
import com.prus.library.domain.Book;
import com.prus.library.domain.Publisher;

import java.util.List;

public interface BookDao {

    void insert(Book book);

    Book getById(int id);

    List<Book> getByYear(int year);

    List<Book> getByType(String type);

    List<Book> getByAuthor(Author author);

    Book getByPublisher(Publisher publisher);

    List<Book> getAll();
}
