package com.prus.library.repository;

import com.prus.library.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
    List<AuthorEntity> findAll();
    List<AuthorEntity> findByFirstName(String name);
    List<AuthorEntity> findByLastName(String name);
    AuthorEntity findByFirstNameAndLastName(String firstName, String lastName);
    AuthorEntity getByAuthorId(long id);
    void deleteByAuthorId(long id);
}
