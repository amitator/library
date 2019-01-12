package com.prus.library.dao;

import com.prus.library.domain.Author;

import java.util.List;

public interface AuthorDao {

    Author getById(int id);

    List<Author> getByFirstName(String firstName);

    List<Author> getByLastName(String lastName);

    void insert(Author author);

    List<Author> getAll();
}
