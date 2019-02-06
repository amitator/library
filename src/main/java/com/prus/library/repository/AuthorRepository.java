package com.prus.library.repository;

import com.prus.library.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository {
    List<AuthorEntity> getAll();
    AuthorEntity getByAuthorId(long id);
    void insert(AuthorEntity authorEntity);
    void deleteByAuthorId(long id);
}
