package com.employee.employeemanagementsystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.employeemanagementsystem.Entities.Employee;
import com.employee.employeemanagementsystem.Services.EmpServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
    @Autowired
    private EmpServices empServices;

    @GetMapping("/")
    public String home(Model model) {
        List<Employee> list = empServices.getAllEmp();
        model.addAttribute("list", list);
        return "index";
    }

    @GetMapping("/addEmp")
    public String addEmp() {
        return "add_emp";
    }

    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee employee, HttpSession session) {
        // System.out.println(employee);

        empServices.addEmp(employee);
        session.setAttribute("msg", "Employee Added Successfully!");

        return "redirect:/";
    }

    @GetMapping("/editEmp/{id}")
    public String editEmp(@PathVariable int id, Model model) {
        Employee employee = empServices.getEmpById(id);

        model.addAttribute("employee", employee);
        
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee employee, HttpSession session){
        empServices.addEmp(employee);
        session.setAttribute("msg", "Employee Details Updated");
        return "redirect:/";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable int id, HttpSession session){

        empServices.deleteEmpById(id);
        session.setAttribute("msg", "Employee Deleted Succesfully!!");
        return "redirect:/";
    }
}
