package com.prus.library.repository;

import com.prus.library.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository {
    List<CommentEntity> getByBookId(Long id);
    void deleteById(Long id);
    void insert(CommentEntity commentEntity);
}
