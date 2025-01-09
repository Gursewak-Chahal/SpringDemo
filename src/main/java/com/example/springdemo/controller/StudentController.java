package com.example.springapp.controler;

import com.example.springapp.student.StudentClass;
import com.example.springapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// get all the students
// localhost:8080/student
public class StudentController {

    @Autowired
    StudentRepository repo;

    @GetMapping()
    public List<StudentClass> getAllStudents() {
        List<StudentClass> students = repo.findAll();
        return students;
    }

    @GetMapping("/{id}")
    public StudentClass getStudentById(@PathVariable int id) {
        try {
            StudentClass student = repo.findById(id).get();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ERROR: An error occurred");
        return null;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentClass student) {
        repo.save(student);
    }

    @PutMapping("/{id}")
    public StudentClass updateStudent(@RequestBody StudentClass student) {
        repo.save(student);
        return student;
    }

    @DeleteMapping("/{id}")
    public void removeStudent(@PathVariable int id) {
        StudentClass student = repo.findById(id).get();
        repo.delete(student);
    }

    @PatchMapping("/{id}")
    public StudentClass updateStudentPatch(@PathVariable int id) {
        StudentClass student = repo.findById(id).get();
        student.setFirstname("Gursewak");
        student.setEmail("harbahajn@gmail.com");
        repo.save(student);
        return student;
    }
}
