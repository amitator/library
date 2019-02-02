package com.prus.library.repository;

import com.prus.library.entities.AuthorEntity;
import com.prus.library.entities.BookEntity;
import com.prus.library.entities.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    BookEntity findById(long id);
    BookEntity findByName(String name);
    List<BookEntity> findByYear(int year);
    List<BookEntity> findByType(String type);
    List<BookEntity> findByAuthorEntityAuthorId(Long authorId);
    List<BookEntity> findByPublisherEntityPublisherId(Long publisherId);
}
