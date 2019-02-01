package com.prus.library.repository;

import com.prus.library.entities.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublisherRepository extends JpaRepository<PublisherEntity, Integer> {
    List<PublisherEntity> findByName(String name);
    List<PublisherEntity> findByCountry(String country);
    PublisherEntity findByPublisherId(long id);
    void deleteByPublisherId(long id);
}
