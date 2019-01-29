package com.prus.library.services;

import com.prus.library.entities.AuthorEntity;

import java.util.List;

public interface AuthorService {
    List<AuthorEntity> findAll();
    List<AuthorEntity> findByFirstName(String firstName);
    List<AuthorEntity> findByFirstNameAndLastName(String firstName, String lastName);
}
