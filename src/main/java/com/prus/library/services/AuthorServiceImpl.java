package com.prus.library.services;

import com.google.common.collect.Lists;
import com.prus.library.entities.AuthorEntity;
import com.prus.library.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Repository
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Override
    public List<AuthorEntity> findAll() {
        return Lists.newArrayList(authorRepository.getAll());
    }

    public List<AuthorEntity> findByFirstName(String firstName){
        return authorRepository.findByFirstName(firstName);
    }

    public List<AuthorEntity> findByLastName(String lastName) { return authorRepository.findByLastName(lastName); }

    public AuthorEntity findByFirstNameAndLastName(String firstName, String lastName){
        return authorRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public AuthorEntity getByAuthorId(long id) {
        return authorRepository.getByAuthorId(id);
    }

    public void save(AuthorEntity authorEntity) {
        authorRepository.insert(authorEntity);
    }

    public void deleteByAuthorId(long id) {
        authorRepository.deleteByAuthorId(id);
    }
}
