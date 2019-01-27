package com.prus.library.repository;

import com.prus.library.entities.AuthorEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AuthorReposiroryJpa1 implements AuthorRepository1 {

    @PersistenceContext
    private EntityManager em;

    @Override
    public AuthorEntity getById(long id) {
//        return em.find(AuthorEntity.class, id);
        return null;
    }

    @Override
    public List<AuthorEntity> getByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<AuthorEntity> getByLastName(String lastName) {
        return null;
    }

    @Override
    public long insert(AuthorEntity authorEntity) {
        em.persist(authorEntity);
        return 1L;
    }

    @Override
    public List<AuthorEntity> getAll() {
        return null;
    }

    @Override
    public boolean existInDatabase(AuthorEntity authorEntity) {
        return false;
    }

    @Override
    public AuthorEntity getByFullName(String f, String l) {
        return null;
    }
}
