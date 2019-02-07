package com.prus.library.repository;

import com.prus.library.entities.AuthorEntity;
import com.prus.library.entities.BookEntity;
import com.prus.library.entities.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository {
    BookEntity getById(long id);
    List<BookEntity> getAll();
    List<BookEntity> getByAuthorId(long AuthorId);
    void deleteById(long id);
    void insert(BookEntity bookEntity);
}
