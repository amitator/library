package com.prus.library.services;

import com.prus.library.entities.AuthorEntity;

import java.util.List;

public interface AuthorService {
    List<AuthorEntity> findAll();
    List<AuthorEntity> findByFirstName(String firstName);
    List<AuthorEntity> findByLastName(String lastName);
    AuthorEntity findByFirstNameAndLastName(String firstName, String lastName);
    AuthorEntity getByAuthorId(long id);
    void save(AuthorEntity authorEntity);
    void deleteByAuthorId(long id);
}
