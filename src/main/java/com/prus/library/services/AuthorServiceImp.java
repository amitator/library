package com.prus.library.services;

import com.google.common.collect.Lists;
import com.prus.library.entities.AuthorEntity;
import com.prus.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service("jpaAuthorService")
@Repository
@Transactional
public class AuthorServiceImp implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<AuthorEntity> findAll() {
        return Lists.newArrayList(authorRepository.findAll());
    }

    public List<AuthorEntity> findByFirstName(String firstName){
        return authorRepository.findByFirstName(firstName);
    }

    public List<AuthorEntity> findByFirstAndLastName(String firstName, String lastName){
        return authorRepository.findByFirstAndLastName(firstName, lastName);
    }

}
