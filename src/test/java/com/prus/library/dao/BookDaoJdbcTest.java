package com.prus.library.dao;

import com.prus.library.domain.Book;
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
public class BookDaoJdbcTest {

    @Autowired
    private BookDao dao;

    @Test
    public void getAllTest(){
        assertThat(dao.getAll().size()).isEqualTo(7);
    }

    @Test
    public void getByIdTest(){
        Book book = dao.getById(1);
        assertThat(book.getId()).isEqualTo(1);
        assertThat(book.getName()).isEqualTo("EFFECTIVE JAVA");
    }

    @Test
    public void getByYearTest(){
        List<Book> list = dao.getByYear(2003);
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getYear()).isEqualTo(2003);
    }

    @Test
        public void getByTypeTest(){
            List<Book> list = dao.getByType("Computer Science");
            assertThat(list.size()).isEqualTo(7);
            assertThat(list.get(0).getType()).isEqualTo("Computer Science");
        }


    @Test
    public void insertTest(){
        Book book = new Book("TestBook", 5555555, 2019, "TestType", 3, 4);
        dao.insert(book);
        assertThat(dao.getAll().size()).isEqualTo(8);
        book = dao.getById(8);
        assertThat(book.getId()).isEqualTo(8);
        assertThat(book.getName()).isEqualTo("TestBook");
    }

}