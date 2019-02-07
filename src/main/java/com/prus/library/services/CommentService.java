package com.prus.library.services;

import com.prus.library.entities.CommentEntity;
import com.prus.library.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository repository;

    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public List<CommentEntity> getByBookId(Long id) {
        return repository.getByBookId(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void insert(CommentEntity commentEntity) {
        repository.insert(commentEntity);
    }

}
