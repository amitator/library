package com.prus.library.dao;

import com.prus.library.entities.AuthorEntity;
import com.prus.library.entities.BookEntity;
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
@Import({BookDaoJdbc.class, AuthorDaoJdbc.class, PublisherDaoJdbc.class})
public class BookEntityDaoJdbcTest {

    @Autowired
    private BookDao dao;

    @Test
    public void getAllTest(){
        assertThat(dao.getAll().size()).isEqualTo(7);
    }

    @Test
    public void getByIdTest(){
        BookEntity bookEntity = dao.getById(1);
        assertThat(bookEntity.getId()).isEqualTo(1);
        assertThat(bookEntity.getName()).isEqualTo("EFFECTIVE JAVA");
    }

    @Test
    public void getByYearTest(){
        List<BookEntity> list = dao.getByYear(2003);
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getYear()).isEqualTo(2003);
    }

    @Test
        public void getByTypeTest(){
            List<BookEntity> list = dao.getByType("Computer Science");
            assertThat(list.size()).isEqualTo(7);
            assertThat(list.get(0).getType()).isEqualTo("Computer Science");
        }


    @Test
    public void insertTest(){
        BookEntity bookEntity = new BookEntity("TestBook", 5555555, 2019, "TestType",
                new PublisherEntity("TEST NAME", "TEST COUNTRY"),
                new AuthorEntity("TEST FIRST", "TEST SECOND"));
        dao.insert(bookEntity);
        assertThat(dao.getAll().size()).isEqualTo(8);
        bookEntity = dao.getById(8);
        assertThat(bookEntity.getId()).isEqualTo(8);
        assertThat(bookEntity.getName()).isEqualTo("TestBook");
    }

}