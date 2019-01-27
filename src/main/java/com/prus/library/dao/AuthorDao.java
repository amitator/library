package com.prus.library.dao;

import com.prus.library.entities.AuthorEntity;

import java.util.List;

public interface AuthorDao {

    AuthorEntity getById(long id);

    List<AuthorEntity> getByFirstName(String firstName);

    List<AuthorEntity> getByLastName(String lastName);

    long insert(AuthorEntity authorEntity);

    List<AuthorEntity> getAll();

    boolean existInDatabase(AuthorEntity authorEntity);

    AuthorEntity getByFullName(String f, String l);
}
