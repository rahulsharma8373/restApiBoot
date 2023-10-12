package com.rahul.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.springboot.bean.Student;

@RestController
public class StudentController {
	@GetMapping("/student")
	public ResponseEntity<Student> getStudent() {
		Student student = new Student(1, "rahul", "sharma");

		// return new ResponseEntity<>(student,HttpStatus.OK);
		return ResponseEntity.ok(student);
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "raja", "kumar"));
		students.add(new Student(2, "maza", "sumar"));
		students.add(new Student(3, "laza", "tumar"));
		students.add(new Student(4, "saza", "kuma"));
		return students;

	}

//springboot rest api with pathvariable
	// {id} - URI template variable
	@GetMapping("student/{id}")
	public Student studentPathVariable(@PathVariable("id") int studentId) {

		return new Student(studentId, "ramesh ", "fadtare");

	}

	@GetMapping("student/{id}/{first-name}/{last-name}")
	public Student studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName,
			@PathVariable("last-name") String lastName) {

		return new Student(studentId, firstName, lastName);

	}

	// http://localhost:8080/students/query?id=1
// RequestParam
	@GetMapping("students/query")
	public Student studentRequestParam(@RequestParam int id) {
		return new Student(id, "ram", "fadataree");
	}

	@GetMapping("students/querys")
	public Student studentRequestParam(@RequestParam int id, @RequestParam String firstName,
			@RequestParam String lastName) {
		return new Student(id, firstName, lastName);
	}

	// springboot rest api that handles HTTP POST request
	// @postmapping and @requestBody
	@PostMapping("student/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return  new ResponseEntity<>(student,HttpStatus.CREATED);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("students/{id}/update")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}

	// DeleteRequest
	@DeleteMapping("students/{id}/delete")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
		System.out.println(studentId);
		return ResponseEntity.ok("Student Deleted successfully");

	}
}
