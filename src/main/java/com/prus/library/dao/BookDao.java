package com.prus.library.dao;

import com.prus.library.domain.Author;
import com.prus.library.domain.Book;
import com.prus.library.domain.Publisher;

import java.util.List;

public interface BookDao {

    void insert(Book book);

    Book getById(int id);

    Book getByYear(int year);

    Book getByType(String type);

    Book getByAuthor(Author author);

    Book getByPublisher(Publisher publisher);

    List<Book> getAll();
}
