package com.prus.library.dao;

import com.prus.library.entities.AuthorEntity;
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
@Import(AuthorDaoJdbc.class)
public class AuthorEntityDaoJdbcTest {

    @Autowired
    private AuthorDao dao;

    @Test
    public void getAllTest(){
        assertThat(dao.getAll().size()).isEqualTo(7);
    }

    @Test
    public void getByIdTest(){
        AuthorEntity authorEntity = dao.getById(1);
        assertThat(authorEntity.getAuthorId()).isEqualTo(1);
        assertThat(authorEntity.getAuthorId()).isEqualTo(1);
    }

    @Test
    public void getByFirstNameTest(){
        List<AuthorEntity> list = dao.getByFirstName("BERT");
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getFirstName()).isEqualTo("BERT");
    }

    @Test
    public void getByLastNameTest(){
        List<AuthorEntity> list = dao.getByLastName("MARTIN");
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getLastName()).isEqualTo("MARTIN");
    }

    @Test
    public void insertTest(){
        AuthorEntity authorEntity = new AuthorEntity("TestAuthor", "TestAuthorLast");
        assertThat(dao.insert(authorEntity)).isEqualTo(8);
        assertThat(dao.getAll().size()).isEqualTo(8);
        authorEntity = dao.getById(8);
        assertThat(authorEntity.getAuthorId()).isEqualTo(8);
        assertThat(authorEntity.getFirstName()).isEqualTo("TestAuthor");
    }

}