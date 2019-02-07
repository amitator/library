package com.prus.library.services;

import com.prus.library.entities.BookEntity;
import com.prus.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService{

    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public BookEntity getById(long id) {
        return repository.getById(id);
    }

    public List<BookEntity> getAll() {
        return repository.getAll();
    }

    public List<BookEntity> getByAuthorId(long authorId) {
        return repository.getByAuthorId(authorId);
    }

    public List<BookEntity> getByPublisherId(long publisherId) {
        return repository.getByPublisherId(publisherId);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public void insert(BookEntity bookEntity) {
        repository.insert(bookEntity);
    }

}
