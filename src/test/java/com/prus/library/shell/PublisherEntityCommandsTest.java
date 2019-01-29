//package com.prus.library.shell;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.shell.Shell;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class PublisherEntityCommandsTest {
//
//    @Autowired
//    private Shell shell;
//
//    @Test
//    public void getPublisherById() throws Exception {
//        assertThat(shell.evaluate(() -> "get-publisher-by-id 1")).isEqualTo("ID: 1\n" +
//                "Name: OREILLY\n" +
//                "Country: US\n");
//    }
//
//    @Test
//    public void getPublisherByName() throws Exception {
//        assertThat(shell.evaluate(() -> "get-publisher-by-name MANNING")).isEqualTo("ID: 4\n" +
//                "Name: MANNING\n" +
//                "Country: US\n");
//    }
//
//}