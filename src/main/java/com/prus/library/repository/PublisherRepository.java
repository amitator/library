package com.prus.library.repository;

import com.prus.library.entities.PublisherEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PublisherRepository extends CrudRepository<PublisherEntity, Integer> {

    List<PublisherEntity> findByName(String name);
    List<PublisherEntity> findByCountry(String country);
    PublisherEntity findByPublisherId(long id);
    void deleteByPublisherId(long id);
}
