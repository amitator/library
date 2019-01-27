package com.prus.library.dao;

import com.prus.library.entities.AuthorEntity;
import com.prus.library.entities.BookEntity;

import java.util.List;

public interface BookDao {

    void insert(BookEntity bookEntity);

    BookEntity getById(long id);

    List<BookEntity> getByYear(int year);

    List<BookEntity> getByType(String type);

    List<BookEntity> getByAuthor(AuthorEntity authorEntity);

    List<BookEntity> getByPublisher(String name);

    List<BookEntity> getAll();
}
