package com.javaguides3.student_management_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaguides3.student_management_project.Entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
