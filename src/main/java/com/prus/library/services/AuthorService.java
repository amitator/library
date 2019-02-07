package com.prus.library.services;

import com.prus.library.entities.AuthorEntity;
import com.prus.library.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<AuthorEntity> getAll() {
        return repository.getAll();
    }

    public AuthorEntity getByAuthorId(long id) {
        return repository.getByAuthorId(id);
    }


    void insert(AuthorEntity authorEntity) {
        repository.insert(authorEntity);
    }

    void deleteByAuthorId(long id){
        repository.deleteByAuthorId(id);
    }

}
