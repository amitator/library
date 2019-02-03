package com.prus.library.repository;

import com.prus.library.entities.CommentEntity;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



@NoArgsConstructor(force = true)
@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository repository;

    @Test
    public void findAllByBookId() {
        assertThat(repository.findAllByBookId(1L)).size().isEqualTo(5);
    }

}