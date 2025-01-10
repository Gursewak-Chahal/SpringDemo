package com.example.springdemo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class StudentControllerTest {
    @Autowired
    private StudentController studentss;
    @Test
    public void testadd()
    {
        assertEquals(4,2+2);
    }
    @Test
    public void findAllStudentTest()
    {
        assertNotNull(studentss.getAllStudents());
    }
    @Test
    public void  findUserByIdTest()
    {
        assertNotNull(studentss.getStudentById(102));

    }
    @Test
    public void createUsersTest() {
        assertNotNull(new Object());
    }
}
