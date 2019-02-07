package com.prus.library.repository;

import com.prus.library.entities.AuthorEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository repository;

    private List<AuthorEntity> list;
    private AuthorEntity entity;

    @Test
    public void findAllTest() {
        assertThat(repository.getAll()).size().isEqualTo(7);
    }

    @Test
    public void getByAuthorIdTest() {
        entity = repository.getByAuthorId(1);
        assertThat(entity.getAuthorId()).isEqualTo(1);
    }

    @Test
    public void saveTest() {
        repository.insert(new AuthorEntity("TEST", "TESTLAST"));
        AuthorEntity entity = repository.getByAuthorId(1);
        assertThat(entity.getFirstName()).isEqualTo("JOSHUA");
        repository.deleteByAuthorId(1L); //so Count would stay the same for deleteByAuthorIdTest()
    }

}