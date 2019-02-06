package com.prus.library.repository;

import com.prus.library.entities.AuthorEntity;

import javax.persistence.EntityManager;
import java.util.List;

//https://www.boraji.com/spring-4-hibernate-5-jpa-2-integration-example

public class AuthorRepositoryImpl implements AuthorRepository {

    private EntityManager em;

    public AuthorRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<AuthorEntity> findAll() {
        return null;
    }

    @Override
    public List<AuthorEntity> findByFirstName(String name) {
        return null;
    }

    @Override
    public List<AuthorEntity> findByLastName(String name) {
        return null;
    }

    @Override
    public AuthorEntity findByFirstNameAndLastName(String firstName, String lastName) {
        return null;
    }

    @Override
    public AuthorEntity getByAuthorId(long id) {
        return null;
    }

    @Override
    public void deleteByAuthorId(long id) {

    }

    @Override
    public void save(AuthorEntity authorEntity) {
        em.persist(authorEntity);
    }
}
