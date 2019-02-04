package com.prus.library.services;

import com.prus.library.entities.AuthorEntity;
import com.prus.library.entities.BookEntity;
import com.prus.library.entities.PublisherEntity;
import com.prus.library.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookServiceImplTest {

    @MockBean
    BookRepository mockRepo;

    @Test
    public void findAllTest() throws Exception {
        List<BookEntity> list = new ArrayList<>();
        list.add(new BookEntity("NAME", 111111, 9999, "TYPE",
                new PublisherEntity("PUBLISHER", "UN"),
                new AuthorEntity("AUTHOR-FIRST-NAME", "AUTHOR-LAST-NAME")));
        list.add(new BookEntity("NAME1", 12442, 888, "TYPE1",
                new PublisherEntity("PUBLISHER1", "UN"),
                new AuthorEntity("AUTHOR-FIRST-NAME1", "AUTHOR-LAST-NAME1")));
        Mockito.when(mockRepo.findAll()).thenReturn(list);
        List<BookEntity> test = mockRepo.findAll();
        assertEquals(list, test);
        Mockito.verify(mockRepo).findAll();
    }

    @Test
    public void findByIdTest() throws Exception {
        BookEntity mockEntity = new BookEntity("NAME", 111111, 9999, "TYPE",
                new PublisherEntity("PUBLISHER", "UN"),
                new AuthorEntity("AUTHOR-FIRST-NAME", "AUTHOR-LAST-NAME"));
        Mockito.when(mockRepo.findById(1)).thenReturn(mockEntity);
        BookEntity test = mockRepo.findById(1L);
        assertEquals(mockEntity, test);
        Mockito.verify(mockRepo).findById(1L);
    }

    @Test
    public void findByNameTest() throws Exception {
        BookEntity mockEntity = new BookEntity("NAME", 111111, 9999, "TYPE",
                new PublisherEntity("PUBLISHER", "UN"),
                new AuthorEntity("AUTHOR-FIRST-NAME", "AUTHOR-LAST-NAME"));
        Mockito.when(mockRepo.findByName("1")).thenReturn(mockEntity);
        BookEntity test = mockRepo.findByName("1");
        assertEquals(mockEntity, test);
        Mockito.verify(mockRepo).findByName("1");
    }

    @Test
    public void findByYearTest() throws Exception {
        List<BookEntity> list = new ArrayList<>();
        list.add(new BookEntity("NAME", 111111, 9999, "TYPE",
                new PublisherEntity("PUBLISHER", "UN"),
                new AuthorEntity("AUTHOR-FIRST-NAME", "AUTHOR-LAST-NAME")));
        list.add(new BookEntity("NAME1", 12442, 888, "TYPE1",
                new PublisherEntity("PUBLISHER1", "UN"),
                new AuthorEntity("AUTHOR-FIRST-NAME1", "AUTHOR-LAST-NAME1")));
        Mockito.when(mockRepo.findByYear(1)).thenReturn(list);
        List<BookEntity> test = mockRepo.findByYear(1);
        assertEquals(list, test);
        Mockito.verify(mockRepo).findByYear(1);
    }

    public void findByTypeTest() throws Exception {
        List<BookEntity> list = new ArrayList<>();
        list.add(new BookEntity("NAME", 111111, 9999, "TYPE",
                new PublisherEntity("PUBLISHER", "UN"),
                new AuthorEntity("AUTHOR-FIRST-NAME", "AUTHOR-LAST-NAME")));
        list.add(new BookEntity("NAME1", 12442, 888, "TYPE1",
                new PublisherEntity("PUBLISHER1", "UN"),
                new AuthorEntity("AUTHOR-FIRST-NAME1", "AUTHOR-LAST-NAME1")));
        Mockito.when(mockRepo.findByType("1")).thenReturn(list);
        List<BookEntity> test = mockRepo.findByType("1");
        assertEquals(list, test);
        Mockito.verify(mockRepo).findByType("1");
    }

    @Test
    public void findByAuthorntityIdTest() throws Exception {
        List<BookEntity> list = new ArrayList<>();
        list.add(new BookEntity("NAME", 111111, 9999, "TYPE",
                new PublisherEntity("PUBLISHER", "UN"),
                new AuthorEntity("AUTHOR-FIRST-NAME", "AUTHOR-LAST-NAME")));
        list.add(new BookEntity("NAME1", 12442, 888, "TYPE1",
                new PublisherEntity("PUBLISHER1", "UN"),
                new AuthorEntity("AUTHOR-FIRST-NAME1", "AUTHOR-LAST-NAME1")));
        Mockito.when(mockRepo.findByAuthorEntityAuthorId(1L)).thenReturn(list);
        List<BookEntity> test = mockRepo.findByAuthorEntityAuthorId(1L);
        assertEquals(list, test);
        Mockito.verify(mockRepo).findByAuthorEntityAuthorId(1L);
    }

    @Test
    public void findByPublisherIdTest() throws Exception {
        List<BookEntity> list = new ArrayList<>();
        list.add(new BookEntity("NAME", 111111, 9999, "TYPE",
                new PublisherEntity("PUBLISHER", "UN"),
                new AuthorEntity("AUTHOR-FIRST-NAME", "AUTHOR-LAST-NAME")));
        list.add(new BookEntity("NAME1", 12442, 888, "TYPE1",
                new PublisherEntity("PUBLISHER1", "UN"),
                new AuthorEntity("AUTHOR-FIRST-NAME1", "AUTHOR-LAST-NAME1")));
        Mockito.when(mockRepo.findByPublisherEntityPublisherId(1L)).thenReturn(list);
        List<BookEntity> test = mockRepo.findByPublisherEntityPublisherId(1L);
        assertEquals(list, test);
        Mockito.verify(mockRepo).findByPublisherEntityPublisherId(1L);
    }

}
