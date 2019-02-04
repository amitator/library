package com.prus.library.services;

import com.prus.library.entities.AuthorEntity;
import com.prus.library.entities.CommentEntity;
import com.prus.library.repository.AuthorRepository;
import com.prus.library.repository.CommentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentServiceImplTest {

    @Mock
    CommentRepository mockRepo;

    @Test
    public void findAllByBookIdTest() throws Exception {
        List<CommentEntity> list = new ArrayList<>();
        list.add(new CommentEntity("1", 1L));
        list.add(new CommentEntity("2", 2L));
        list.add(new CommentEntity("3", 3L));
        Mockito.when(mockRepo.findAllByBookId(1L)).thenReturn(list);
        List<CommentEntity> test = mockRepo.findAllByBookId(1L);
        assertEquals(list, test);
        Mockito.verify(mockRepo).findAllByBookId(1L);
    }


}
