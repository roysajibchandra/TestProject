package com.employee.employeemanagementsystem.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employeemanagementsystem.Entities.Employee;
import com.employee.employeemanagementsystem.Repository.EmpRepository;

@Service
public class EmpServices {
    
    @Autowired
    private EmpRepository empRepository;

    public void addEmp(Employee employee){
        empRepository.save(employee);
    }

    public List<Employee> getAllEmp(){
        return empRepository.findAll();
    }

    public Employee getEmpById(int id){
        Optional<Employee> employee = empRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        return null;
    }

    public void deleteEmpById(int id){
        empRepository.deleteById(id);
    }
}
