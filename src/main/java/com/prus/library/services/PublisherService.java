package com.prus.library.services;

import com.prus.library.entities.PublisherEntity;

import java.util.List;

public interface PublisherService {

    List<PublisherEntity> findAll();
    List<PublisherEntity> findByName(String name);
    List<PublisherEntity> findByCountry(String country);
    PublisherEntity findByPublisherId(long id);
    void deleteByPublisherId(long id);
    void save(PublisherEntity publisherEntity);

}
