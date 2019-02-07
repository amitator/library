package com.prus.library.repository;

import com.prus.library.entities.BookEntity;
import com.prus.library.entities.PublisherEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@SuppressWarnings("JpaQlInspection")
public class PublisherRepositoryImpl implements PublisherRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PublisherEntity> getAll() {
        TypedQuery query = em.createQuery("select p from PublisherEntity p", PublisherEntity.class);
        return query.getResultList();
    }

    @Override
    public PublisherEntity findByPublisherId(long id) {
        return em.find(PublisherEntity.class, id);
    }

    @Override
    public void deleteByPublisherId(long id) {
        PublisherEntity entity = em.find(PublisherEntity.class, id);
        em.remove(entity);
    }

    @Override
    public void insert(PublisherEntity publisherEntity) {
        em.persist(publisherEntity);
    }

}
