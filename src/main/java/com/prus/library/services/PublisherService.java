package com.prus.library.services;

import com.prus.library.entities.PublisherEntity;
import com.prus.library.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private PublisherRepository repository;

    public PublisherService (PublisherRepository repository) {
        this.repository = repository;
    }

    public List<PublisherEntity> getAll() {
        return repository.getAll();
    }

    public PublisherEntity findByPublisherId(long id) {
        return repository.findByPublisherId(id);
    }

    public void deleteByPublisherId(long id) {
        repository.deleteByPublisherId(id);
    }

    public void insert(PublisherEntity publisherEntity) {
        repository.insert(publisherEntity);
    }

}
