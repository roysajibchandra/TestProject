package com.javaguides3.student_management_project.Services;

import java.util.List;

import com.javaguides3.student_management_project.Entities.Student;

public interface StudentServices {
    List<Student> getAllStudent();

    Student saveStudent(Student student);

    Student getStudentById(Long id);
    Student updateStudent(Student student);
    void deleteStudentById(Long id);
}
