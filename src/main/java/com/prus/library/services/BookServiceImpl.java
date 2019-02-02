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
    public BookEntity findById(long id) {
        return null;
    }

    @Override
    public List<BookEntity> findByYear(int year) {
        return null;
    }

    @Override
    public List<BookEntity> findByType(String type) {
        return null;
    }

    @Override
    public List<BookEntity> findByPublisherPublisherId(Long id) {
        return null;
    }

    @Override
    public void save(BookEntity bookEntity) {

    }
}
