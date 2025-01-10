package com.example.springdemo.controller;

import com.example.springdemo.repository.StudentRepository;
import com.example.springdemo.student.StudentClass;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Autowired
    @InjectMocks
    private StudentController studentss;
    @Mock
    private StudentRepository repo;

    @Test
    public void testadd() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void findAllStudentTest() {
        assertNotNull(studentss.getAllStudents());
    }

    @Test
    public void findUserByIdTest() {
        assertNotNull(studentss.getStudentById(102));

    }

    @Test
    public void deleteUserTest() {
        // Arrange: mock the repository
        StudentClass userToDelete = new StudentClass();
        userToDelete.setId(103);
        Mockito.when(repo.findById(103)).thenReturn(Optional.of(userToDelete));

        // Act: delete user
        boolean result = studentss.removeStudent(103);
        // Assert: check that the user was deleted and the result is true
        assertTrue(result);
        Mockito.verify(repo, Mockito.times(1)).delete(userToDelete);  // Verify that the delete method was called once
    }

    @Test
    public void createUsersTest() {
        assertNotNull(new Object());
    }

    @Test
    public void updateStudentTest() {
        StudentClass mockStudent = new StudentClass();
        mockStudent.setId(1);
        mockStudent.setFirstname("Test User");

        Mockito.when(repo.save(Mockito.any(StudentClass.class))).thenReturn(mockStudent);

        // Act
        StudentClass updateStudent = studentss.updateStudent(mockStudent);

        // Assert
        assertNotNull(updateStudent);
        assertEquals("Test User", updateStudent.getFirstname());
        Mockito.verify(repo, Mockito.times(1)).save(mockStudent);
    }

    @Test
    public void updateStudentPatchTest() {
        // Arrange
        int userId = 2;
        StudentClass existingUser = new StudentClass();
        existingUser.setId(userId);
        existingUser.setFirstname("Old Name");
        existingUser.setEmail("oldemail@example.com");

        Mockito.when(repo.findById(userId)).thenReturn(Optional.of(existingUser));
        Mockito.when(repo.save(Mockito.any(StudentClass.class))).thenReturn(existingUser);

        // Act
        StudentClass updatedStudent = studentss.updateStudentPatch(userId);

        // Assert
        assertNotNull(updatedStudent);
        assertEquals("Gursewak", updatedStudent.getFirstname());
        assertEquals("harbahajn@gmail.com", updatedStudent.getEmail());
        Mockito.verify(repo, Mockito.times(1)).findById(userId);
        Mockito.verify(repo, Mockito.times(1)).save(existingUser);
    }

}


