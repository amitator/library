package com.prus.library.repository;

import com.prus.library.entities.AuthorEntity;
import com.prus.library.entities.BookEntity;
import com.prus.library.entities.PublisherEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.awt.print.Book;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public BookEntity getById(long id) {
        return em.find(BookEntity.class, id);
    }

    @Override
    public List<BookEntity> getAll() {
        TypedQuery query = em.createQuery("select b from BookEntity b", BookEntity.class);
        return query.getResultList();
    }

    @Override
    public List<BookEntity> getByAuthorId(long AuthorId) {
        return null;
    }

    @Override
    public void deleteById(long id) {
        BookEntity entity = em.find(BookEntity.class, id);
        em.remove(entity);
    }

    @Override
    public void insert(BookEntity bookEntity) {
        AuthorEntity authorEntity = em.find(AuthorEntity.class, bookEntity.getAuthorEntity().getAuthorId());
        PublisherEntity publisherEntity = em.find(PublisherEntity.class, bookEntity.getPublisherEntity().getPublisherId());
        bookEntity.setAuthorEntity(authorEntity);
        bookEntity.setPublisherEntity(publisherEntity);
        em.persist(bookEntity);
    }
}
