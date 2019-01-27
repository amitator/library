package com.prus.library.repository;

import com.prus.library.entities.AuthorEntity;

import java.util.List;

public interface AuthorRepository1 {

    AuthorEntity getById(long id);

    List<AuthorEntity> getByFirstName(String firstName);

    List<AuthorEntity> getByLastName(String lastName);

    long insert(AuthorEntity authorEntity);

    List<AuthorEntity> getAll();

    boolean existInDatabase(AuthorEntity authorEntity);

    AuthorEntity getByFullName(String f, String l);
}
