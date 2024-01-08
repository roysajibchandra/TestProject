package com.javaguides3.student_management_project.StudentServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaguides3.student_management_project.Entities.Student;
import com.javaguides3.student_management_project.Repository.StudentRepository;
import com.javaguides3.student_management_project.Services.StudentServices;

@Service
public class StudentServicesImpl implements StudentServices {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {

        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {

        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
