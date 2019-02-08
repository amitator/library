package com.prus.library.repository;

import com.prus.library.entities.AuthorEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @PersistenceContext
    private EntityManager em;

    public AuthorRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<AuthorEntity> getAll() {
        TypedQuery<AuthorEntity> query = em.createQuery("select a from AuthorEntity a", AuthorEntity.class);
        return query.getResultList();
    }

    @Override
    public AuthorEntity getByAuthorId(long id) {
        return em.find(AuthorEntity.class, id);
    }

    @Override
    public void deleteByAuthorId(long id) {
        AuthorEntity authorEntity = em.find(AuthorEntity.class, id);
        em.remove(authorEntity);
    }

    @Override
    @Transactional
    public void insert(AuthorEntity authorEntity) {
        em.persist(authorEntity);
    }
}
