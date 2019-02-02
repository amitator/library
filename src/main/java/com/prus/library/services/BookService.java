package com.prus.library.services;

import com.prus.library.entities.AuthorEntity;
import com.prus.library.entities.BookEntity;

import java.util.List;

public interface BookService {
    List<BookEntity> findAll();
    BookEntity findById(long id);
    List<BookEntity> findByYear(int year);
    List<BookEntity> findByType(String type);
    List<BookEntity> findByAuthorEntityAuthorId(Long id);
    List<BookEntity> findByPublisherEntityPublisherId(Long id);
    void save(BookEntity bookEntity);

}
