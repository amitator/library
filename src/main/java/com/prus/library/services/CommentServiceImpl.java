package com.prus.library.services;

import com.prus.library.entities.CommentEntity;
import com.prus.library.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Repository
@Transactional
public class CommentServiceImpl implements CommentService {

    private CommentRepository repository;

    @Override
    public List<CommentEntity> findAllByBookId(Long id) {
        return repository.findAllByBookId(id);
    }

    @Override
    public void save(CommentEntity commentEntity) {
        repository.save(commentEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
