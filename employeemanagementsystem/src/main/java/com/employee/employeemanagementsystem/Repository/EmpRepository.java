package com.employee.employeemanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.employeemanagementsystem.Entities.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer>{
    
}
