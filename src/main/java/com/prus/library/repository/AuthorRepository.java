package com.prus.library.repository;

import com.prus.library.entities.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<AuthorEntity, Integer>{

    List<AuthorEntity> findByFirstName(String Name);
    List<AuthorEntity> findByLastName(String Name);
    AuthorEntity findByFirstNameAndLastName(String firstName, String lastName);
    AuthorEntity getByAuthorId(long id);
}
