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

    public void findByFirstName() {
        List<AuthorEntity> list = repository.findByFirstName("BERT");
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getFirstName()).isEqualTo("BERT");
    }

    public void findByLastName() {
        List<AuthorEntity> list = repository.findByLastName("MARTIN");
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getLastName()).isEqualTo("MARTIN");
    }

    public void findByFirstNameAndLastName() {
        AuthorEntity entity = repository.findByFirstNameAndLastName("BERT", "MARTIN");
        assertThat(entity.getFirstName()).isEqualTo("BERT");
        assertThat(entity.getLastName()).isEqualTo("MARTIN");
    }

    public void getByAuthorId() {
        AuthorEntity authorEntity = repository.getByAuthorId(1);
        assertThat(authorEntity.getAuthorId()).isEqualTo(1);
    }

    public void deleteByAuthorId() {
        repository.deleteById(1);
        assertThat(repository.findAll()).size().isEqualTo(6);
    }

}