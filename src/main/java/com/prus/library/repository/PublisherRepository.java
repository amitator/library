package com.prus.library.repository;

import com.prus.library.entities.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublisherRepository {
    List<PublisherEntity> getAll();
    PublisherEntity findByPublisherId(long id);
    void deleteByPublisherId(long id);
    void insert(PublisherEntity publisherEntity);
}
