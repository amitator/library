package com.prus.library.repository;

import com.prus.library.entities.BookEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findAllTest() {
        assertThat(repository.findAll().size()).isEqualTo(7);
    }

    @Test
    public void findByIdTest() {
        BookEntity entity = repository.findById(1);
        assertThat(entity.getId()).isEqualTo(1);
        assertThat(entity.getName()).isEqualTo("EFFECTIVE JAVA");
    }

    @Test
    public void findByNameTest() {
        BookEntity entity = repository.findByName("EFFECTIVE JAVA");
        assertThat(entity.getId()).isEqualTo(1);
        assertThat(entity.getName()).isEqualTo("EFFECTIVE JAVA");
    }

    @Test
    public void findByYearTest() {
        List<BookEntity> list = repository.findByYear(2003);
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getYear()).isEqualTo(2003);
    }

    @Test
    public void findByTypeTest() {
        List<BookEntity> list = repository.findByType("Computer Science");
        assertThat(list.size()).isEqualTo(7);
        assertThat(list.get(0).getType()).isEqualTo("Computer Science");
    }

    public void findByAuthorEntityAuthorId() {
        List<BookEntity> list = repository.findByAuthorEntityAuthorId(1L);
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getName()).isEqualTo("EFFECTIVE JAVA");
    }

    public void findByPublisherEntityPublisherId() {
        List<BookEntity> list = repository.findByPublisherEntityPublisherId(1L);
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getName()).isEqualTo("EFFECTIVE JAVA");
    }

}