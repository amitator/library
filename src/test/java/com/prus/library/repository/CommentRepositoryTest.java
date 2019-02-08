package com.prus.library.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(CommentRepositoryImpl.class)
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository repository;

    @Test
    public void findAllByBookIdTest() {
        assertThat(repository.getByBookId(1L)).size().isEqualTo(5);
    }

}