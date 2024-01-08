package com.javaguides3.student_management_project.Controller;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.javaguides3.student_management_project.Entities.Student;

// import org.springframework.web.bind.annotation.RestController;

import com.javaguides3.student_management_project.Services.StudentServices;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentController {

    private StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping("/students")
    public String listStudent(Model model) {
        model.addAttribute("students", studentServices.getAllStudent());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();

        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {

        studentServices.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentServices.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
     @ModelAttribute("student") Student student,
     Model model){

        // get student from database by id
        Student exitingStudent = studentServices.getStudentById(id);
        exitingStudent.setId(id);
        exitingStudent.setFirstName(student.getFirstName());
        exitingStudent.setLastName(student.getLastName());
        exitingStudent.setEmail(student.getEmail());

        // save update student object
        studentServices.updateStudent(exitingStudent);
        return "redirect:/students";

    }

    // handler method to handle delete student request
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentServices.deleteStudentById(id);
        return "redirect:/students";
    }
    
}
