//package com.prus.library.services;
//
//import com.prus.library.entities.PublisherEntity;
//import com.prus.library.repository.PublisherRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class PublisherServiceTest {
//
//    @MockBean
//    PublisherRepository mockRepo;
//
//    @Test
//    public void findAllTest() throws Exception {
//        List<PublisherEntity> list = new ArrayList<>();
//        list.add(new PublisherEntity("1", "1"));
//        list.add(new PublisherEntity("2", "2"));
//        list.add(new PublisherEntity("3", "3"));
//        Mockito.when(mockRepo.findAll()).thenReturn(list);
//        List<PublisherEntity> test = mockRepo.findAll();
//        assertEquals(list, test);
//        Mockito.verify(mockRepo).findAll();
//    }
//
//    @Test
//    public void findByCountryTest() throws Exception {
//        List<PublisherEntity> list = new ArrayList<>();
//        list.add(new PublisherEntity("1", "1"));
//        list.add(new PublisherEntity("2", "2"));
//        list.add(new PublisherEntity("3", "3"));
//        Mockito.when(mockRepo.findByCountry("1")).thenReturn(list);
//        List<PublisherEntity> test = mockRepo.findByCountry("1");
//        assertEquals(list, test);
//        Mockito.verify(mockRepo).findByCountry("1");
//    }
//
//    @Test
//    public void findByNameTest() throws Exception {
//        List<PublisherEntity> list = new ArrayList<>();
//        list.add(new PublisherEntity("1", "1"));
//        list.add(new PublisherEntity("2", "2"));
//        list.add(new PublisherEntity("3", "3"));
//        Mockito.when(mockRepo.findByName("1")).thenReturn(list);
//        List<PublisherEntity> test = mockRepo.findByName("1");
//        assertEquals(list, test);
//        Mockito.verify(mockRepo).findByName("1");
//    }
//
//    @Test
//    public void findByPublisherIdTest() throws Exception {
//        PublisherEntity mockEntity = new PublisherEntity("1", "1");
//        Mockito.when(mockRepo.findByPublisherId(1)).thenReturn(mockEntity);
//        PublisherEntity test = mockRepo.findByPublisherId(1);
//        assertEquals(mockEntity, test);
//        Mockito.verify(mockRepo).findByPublisherId(1);
//    }
//
//}
