package com.prus.library.services;

import com.google.common.collect.Lists;
import com.prus.library.entities.PublisherEntity;
import com.prus.library.repository.PublisherRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PublisherServiceImpl implements PublisherService {

    private PublisherRepository publisherRepository;

    public PublisherServiceImpl (PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<PublisherEntity> findAll() {
        return Lists.newArrayList(publisherRepository.findAll());
    }

    @Override
    public List<PublisherEntity> findByName(String name) {
        return publisherRepository.findByName(name);
    }

    @Override
    public List<PublisherEntity> findByCountry(String country) {
        return publisherRepository.findByCountry(country);
    }

    @Override
    public PublisherEntity findByPublisherId(long id) {
        return publisherRepository.findByPublisherId(id);
    }

    @Override
    public void deleteByPublisherId(long id) {
        publisherRepository.deleteByPublisherId(id);
    }

    @Override
    public void save(PublisherEntity publisherEntity) {
        publisherRepository.save(publisherEntity);
    }
}
