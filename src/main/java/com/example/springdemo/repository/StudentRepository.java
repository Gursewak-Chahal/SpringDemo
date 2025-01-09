package com.example.springdemo.repository;

import com.example.springdemo.student.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentClass, Integer> {
}
