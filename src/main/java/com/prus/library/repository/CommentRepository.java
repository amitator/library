package com.prus.library.repository;

import com.prus.library.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    List<CommentEntity> findAllByBookId(Long id);
    void deleteById(Long id);
}
