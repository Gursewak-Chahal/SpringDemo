package com.example.springapp.repository;

import com.example.springapp.student.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentClass, Integer> {
}
