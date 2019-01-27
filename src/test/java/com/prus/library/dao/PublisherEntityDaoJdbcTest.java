package com.prus.library.dao;

import com.prus.library.entities.PublisherEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@JdbcTest
@Import(PublisherDaoJdbc.class)
public class PublisherEntityDaoJdbcTest {

    @Autowired
    private PublisherDao dao;

    @Test
    public void getAllTest(){
        assertThat(dao.getAll().size()).isEqualTo(4);
    }

    @Test
    public void getByIdTest(){
        PublisherEntity publisherEntity = dao.getById(1);
        assertThat(publisherEntity.getPublisherId()).isEqualTo(1);
        assertThat(publisherEntity.getPublisherId()).isEqualTo(1);
    }

    @Test
    public void getByNameTest(){
        PublisherEntity publisherEntity = dao.getByName("MANNING");
        assertThat(publisherEntity.getName()).isEqualTo("MANNING");
    }

    @Test
    public void getByCountryTest(){
        List<PublisherEntity> list = dao.getByCountry("US");
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(0).getCountry()).isEqualTo("US");
    }

    @Test
    public void insertTest(){
        PublisherEntity publisherEntity = new PublisherEntity("TestPublisher", "TestPublisher");
        dao.insert(publisherEntity);
        assertThat(dao.getAll().size()).isEqualTo(5);
        publisherEntity = dao.getById(5);
        assertThat(publisherEntity.getPublisherId()).isEqualTo(5);
        assertThat(publisherEntity.getName()).isEqualTo("TestPublisher");
    }

}