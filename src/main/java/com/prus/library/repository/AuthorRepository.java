package com.prus.library.repository;

import com.prus.library.entities.Author;

import java.util.List;

public interface AuthorRepository {

    Author getById(long id);

    List<Author> getByFirstName(String firstName);

    List<Author> getByLastName(String lastName);

    long insert(Author author);

    List<Author> getAll();

    boolean existInDatabase(Author author);

    Author getByFullName(String f, String l);
}
