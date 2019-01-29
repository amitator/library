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
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class AuthorEntityCommandsTest {
//
//    @Autowired
//    private Shell shell;
//
//    @Test
//    public void getAuthorById(){
//        assertThat(shell.evaluate(() -> "get-author-by-id 1")).isEqualTo("ID: 1\n" +
//                "First name: JOSHUA\n" +
//                "Last name: BLOCH\n");
//    }
//
//    @Test
//    public void getAuthorsByFirstNameTest(){
//        assertThat(shell.evaluate(() -> "get-authors-by-first-name BRUCE")).isEqualTo("ID: 3\n" +
//                "First name: BRUCE\n" +
//                "Last name: ECKEL\n");
//    }
//
//    @Test
//    public void getAuthorsByLastNameTest(){
//        assertThat(shell.evaluate(() -> "get-authors-by-last-name WALLS")).isEqualTo("ID: 7\n" +
//                "First name: CRAIG\n" +
//                "Last name: WALLS\n");
//    }
//
//}
