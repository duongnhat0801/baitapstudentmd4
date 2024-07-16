package com.codegym.student.services;

import com.codegym.student.models.Student;
import com.codegym.student.repositories.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepo studentRepo;

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public Student findById(Long id) {
        return  studentRepo.findById(id);
    }
}
