package com.prus.library.dao;

import com.prus.library.domain.Author;
import com.prus.library.domain.Publisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherDaoJdbcTest {

    @Autowired
    private PublisherDao dao;

    @Test
    public void getAllTest(){
        assertThat(dao.getAll().size()).isEqualTo(4);
    }

    @Test
    public void getByIdTest(){
        Publisher publisher = dao.getById(1);
        assertThat(publisher.getPublisherId()).isEqualTo(1);
        assertThat(publisher.getPublisherId()).isEqualTo(1);
    }

    @Test
    public void getByNameTest(){
        Publisher publisher = dao.getByName("MANNING");
        assertThat(publisher.getName()).isEqualTo("MANNING");
    }

    @Test
    public void getByCountryTest(){
        List<Publisher> list = dao.getByCountry("US");
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(0).getCountry()).isEqualTo("US");
    }

    @Test
    public void insertTest(){
        Publisher publisher = new Publisher("TestPublisher", "TestPublisher");
        dao.insert(publisher);
        assertThat(dao.getAll().size()).isEqualTo(5);
        publisher = dao.getById(5);
        assertThat(publisher.getPublisherId()).isEqualTo(5);
        assertThat(publisher.getName()).isEqualTo("TestPublisher");
    }

}