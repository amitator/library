package com.prus.library.services;

import com.prus.library.entities.CommentEntity;

import java.util.List;

public interface CommentService {
    List<CommentEntity> findAllByBookId(Long id);
    void save(CommentEntity commentEntity);
    void deleteById(Long id);
}
