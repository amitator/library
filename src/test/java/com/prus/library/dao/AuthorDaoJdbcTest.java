package com.prus.library.dao;

import com.prus.library.domain.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@JdbcTest
@Import(AuthorDaoJdbc.class)
public class AuthorDaoJdbcTest {

    @Autowired
    private AuthorDao dao;

    @Test
    public void getAllTest(){
        assertThat(dao.getAll().size()).isEqualTo(7);
    }

    @Test
    public void getByIdTest(){
        Author author = dao.getById(1);
        assertThat(author.getAuthorId()).isEqualTo(1);
        assertThat(author.getAuthorId()).isEqualTo(1);
    }

    @Test
    public void getByFirstNameTest(){
        List<Author> list = dao.getByFirstName("BERT");
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getFirstName()).isEqualTo("BERT");
    }

    @Test
    public void getByLastNameTest(){
        List<Author> list = dao.getByLastName("MARTIN");
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getLastName()).isEqualTo("MARTIN");
    }

    @Test
    public void insertTest(){
        Author author = new Author("TestAuthor", "TestAuthorLast");
        dao.insert(author);
        assertThat(dao.getAll().size()).isEqualTo(8);
        author = dao.getById(8);
        assertThat(author.getAuthorId()).isEqualTo(8);
        assertThat(author.getFirstName()).isEqualTo("TestAuthor");
    }

}