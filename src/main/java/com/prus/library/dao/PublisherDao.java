package com.prus.library.dao;

import com.prus.library.domain.Publisher;

import java.util.List;

public interface PublisherDao {

    Publisher getById(int id);

    List<Publisher> getByName(String firstName);

    List<Publisher> getByCountry(String country);

    void insert(Publisher author);

    List<Publisher> getAll();
}
