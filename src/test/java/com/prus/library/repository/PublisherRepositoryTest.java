package com.prus.library.repository;

import com.prus.library.entities.PublisherEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PublisherRepositoryTest {

    @Autowired
    private PublisherRepository repository;

    @Test
    public void findAll() {
        assertThat(repository.findAll()).size().isEqualTo(4);
    }

    @Test
    public void findByNameTest() throws Exception {
        List<PublisherEntity> list = repository.findByName("MANNING");
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getName()).isEqualTo("MANNING");
    }

    @Test
    public void findByCountryTest() throws Exception {
        List<PublisherEntity> list = repository.findByCountry("US");
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(0).getName()).isEqualTo("OREILLY");
    }

    @Test
    public void findByPublisherIdTest() throws Exception {
        PublisherEntity entity = repository.findByPublisherId(1);
        assertThat(entity.getPublisherId()).isEqualTo(1);
    }

}
