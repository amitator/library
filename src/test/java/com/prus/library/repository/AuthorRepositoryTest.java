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

    @Test
    public void findAllTest() {
        assertThat(repository.findAll()).size().isEqualTo(7);
    }

    @Test
    public void findByFirstNameTest() {
        List<AuthorEntity> list = repository.findByFirstName("JOSHUA");
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getFirstName()).isEqualTo("JOSHUA");
    }

    @Test
    public void findByLastNameTest() {
        List<AuthorEntity> list = repository.findByLastName("BLOCH");
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getLastName()).isEqualTo("BLOCH");
    }

    @Test
    public void findByFirstNameAndLastNameTest() {
        AuthorEntity entity = repository.findByFirstNameAndLastName("JOSHUA", "BLOCH");
        assertThat(entity.getFirstName()).isEqualTo("JOSHUA");
        assertThat(entity.getLastName()).isEqualTo("BLOCH");
    }

    @Test
    public void getByAuthorIdTest() {
        AuthorEntity entity = repository.getByAuthorId(1);
        assertThat(entity.getAuthorId()).isEqualTo(1);
    }

    @Test
    public void saveTest() {
        repository.save(new AuthorEntity("TEST", "TESTLAST"));
        AuthorEntity entity = repository.getByAuthorId(1);
        assertThat(entity.getFirstName()).isEqualTo("JOSHUA");
        repository.deleteByAuthorId(1L); //so Count would stay the same for deleteByAuthorIdTest()
    }

}