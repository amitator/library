package com.prus.library.services;

import com.prus.library.entities.AuthorEntity;
import com.prus.library.repository.AuthorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthorServiceImplTest {

    @Mock
    AuthorRepository mockRepo;

    private List< AuthorEntity> list;
    private AuthorEntity mockEntity;

    @Test
    public void findAllTest() throws Exception {
        list = new ArrayList<>();
        list.add(new AuthorEntity("1", "1"));
        list.add(new AuthorEntity("2", "2"));
        list.add(new AuthorEntity("3", "3"));
        Mockito.when(mockRepo.findAll()).thenReturn(list);
        List<AuthorEntity> test = mockRepo.findAll();
        assertEquals(list, test);
        Mockito.verify(mockRepo).findAll();
    }

    @Test
    public void findByFirstNameTest() throws Exception {
        list = new ArrayList<>();
        list.add(new AuthorEntity("1", "1"));
        list.add(new AuthorEntity("2", "2"));
        list.add(new AuthorEntity("3", "3"));
        Mockito.when(mockRepo.findByFirstName("1")).thenReturn(list);
        List<AuthorEntity> test = mockRepo.findByFirstName("1");
        assertEquals(list, test);
        Mockito.verify(mockRepo).findByFirstName("1");
    }

    @Test
    public void findByLastNameTest() throws Exception {
        list = new ArrayList<>();
        list.add(new AuthorEntity("1", "1"));
        list.add(new AuthorEntity("2", "2"));
        list.add(new AuthorEntity("3", "3"));
        Mockito.when(mockRepo.findByLastName("1")).thenReturn(list);
        List<AuthorEntity> test = mockRepo.findByLastName("1");
        assertEquals(list, test);
        Mockito.verify(mockRepo).findByLastName("1");
    }

    @Test
    public void findByFirstNameAndLastNameTest() throws Exception {
        mockEntity = new AuthorEntity("1", "1");
        Mockito.when(mockRepo.findByFirstNameAndLastName("1", "1")).thenReturn(mockEntity);
        AuthorEntity test = mockRepo.findByFirstNameAndLastName("1", "1");
        assertEquals(mockEntity, test);
        Mockito.verify(mockRepo).findByFirstNameAndLastName("1", "1");
    }

    @Test
    public void getByAuthorIdTest() throws Exception {
        mockEntity = new AuthorEntity("1", "1");
        Mockito.when(mockRepo.getByAuthorId(1)).thenReturn(mockEntity);
        AuthorEntity test = mockRepo.getByAuthorId(1);
        assertEquals(mockEntity, test);
        Mockito.verify(mockRepo).getByAuthorId(1);
    }

}
