package com.codegym.student.repositories;

import com.codegym.student.models.Student;

import java.util.List;

public interface IStudentRepo {
    List<Student> findAll();

    void save(Student student);

    Student findById(Long id);
}
