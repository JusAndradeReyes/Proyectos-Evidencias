package com.student.controller;
import java.util.List;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.student.modelo.Student;
@RestController
public class StudentController {
	
	//ENDPOINT GET: http://localhost:7575/listar/student
	@GetMapping("/listar/student")
	public Student listarStudents() {
		Student student = new Student(
				500,
				Set.of("ESPAÑOL","INGLÉS","PORTUGUES","ALEMÁN"),
				List.of(90,80,85,100),
				new String[] {"1ro","2do","3ro","4to"});
		return student;
	}
}
