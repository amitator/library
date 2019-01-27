package com.prus.library.dao;

import com.prus.library.entities.PublisherEntity;

import java.util.List;

public interface PublisherDao {

    PublisherEntity getById(long id);

    PublisherEntity getByName(String name);

    List<PublisherEntity> getByCountry(String country);

    long insert(PublisherEntity author);

    List<PublisherEntity> getAll();

    boolean existInDatabase(PublisherEntity publisherEntity);
}
