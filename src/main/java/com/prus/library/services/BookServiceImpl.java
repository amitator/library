package com.prus.library.services;

import com.prus.library.entities.BookEntity;
import com.prus.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Repository
@Transactional
public class BookServiceImpl implements BookService{

    private BookRepository repository;

    @Override
    public List<BookEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public BookEntity findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public BookEntity findById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<BookEntity> findByYear(int year) {
        return repository.findByYear(year);
    }

    @Override
    public List<BookEntity> findByType(String type) {
        return repository.findByType(type);
    }

    @Override
    public List<BookEntity> findByAuthorEntityAuthorId(Long id) {
        return repository.findByAuthorEntityAuthorId(id);
    }

    @Override
    public List<BookEntity> findByPublisherEntityPublisherId(Long id) {
        return repository.findByPublisherEntityPublisherId(id);
    }

    @Override
    public void save(BookEntity bookEntity) {
        repository.save(bookEntity);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
