package com.prus.library.repository;

import com.prus.library.entities.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AuthorReposiroryJpa implements AuthorRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Author getById(long id) {
//        return em.find(Author.class, id);
        return null;
    }

    @Override
    public List<Author> getByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Author> getByLastName(String lastName) {
        return null;
    }

    @Override
    public long insert(Author author) {
        em.persist(author);
        return 1L;
    }

    @Override
    public List<Author> getAll() {
        return null;
    }

    @Override
    public boolean existInDatabase(Author author) {
        return false;
    }

    @Override
    public Author getByFullName(String f, String l) {
        return null;
    }
}
