package com.prus.library.repository;

import com.prus.library.entities.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<AuthorEntity, Integer>{

    List<AuthorEntity> findByFirstName(String name);
    List<AuthorEntity> findByLastName(String name);
    AuthorEntity findByFirstNameAndLastName(String firstName, String lastName);
    AuthorEntity getByAuthorId(long id);
    void deleteByAuthorId(long id);
}
