package com.prus.library.dao;

import com.prus.library.domain.Publisher;

import java.util.List;

public interface PublisherDao {

    Publisher getById(long id);

    Publisher getByName(String name);

    List<Publisher> getByCountry(String country);

    void insert(Publisher author);

    List<Publisher> getAll();

    boolean existInDatabase(Publisher publisher);
}
