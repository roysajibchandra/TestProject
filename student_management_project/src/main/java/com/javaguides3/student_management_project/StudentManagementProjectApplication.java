package com.javaguides3.student_management_project;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import com.javaguides3.student_management_project.Entities.Student;
// import com.javaguides3.student_management_project.Repository.StudentRepository;

@SpringBootApplication
public class StudentManagementProjectApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementProjectApplication.class, args);
		System.out.println("Check");
	}
	// @Autowired
	// private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

	// 	// Student student1 = new Student(null, "Sajib", "Roy", "@sajib");
	// 	// studentRepository.save(student1);

	// 	// Student student2 = new Student(null, "Sajib", "Roy", "@sajib");
	// 	// studentRepository.save(student2);

	// 	// Student student3 = new Student(null, "Sajib", "Roy", "@sajib");
	// 	// studentRepository.save(student3);
	}

}
