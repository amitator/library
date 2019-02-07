package com.prus.library.repository;

import com.prus.library.entities.CommentEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CommentEntity> getByBookId(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        CommentEntity commentEntity = em.find(CommentEntity.class, id);
        em.remove(commentEntity);
    }

    @Override
    public void insert(CommentEntity commentEntity) {
        em.persist(commentEntity);
    }
}
