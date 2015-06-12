package com.trekiz.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trekiz.hibernate.bean.Student;
import com.trekiz.hibernate.service.StudentService;

@Controller
@RequestMapping(value="a/test")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value="findStudentById",method=RequestMethod.GET)
	public void findStudentById(@RequestParam(value="id")Integer id) {
		Student student = studentService.findStudentById(id);
		System.out.println(student);
	}

	public void findStudentByName(String name) {
		List<Student> student = studentService.findStudentByName(name);
		System.out.println(student.get(0));
		System.out.println(student.size());
	}

	public void findStudentSomeAttr(Integer id) {
		Student student = studentService.findStudentSomeAttr(id);
		System.out.println(student);
	}

	public void findStudentSomeAttr(String name) {
		List<Student> student = studentService.findStudentSomeAttr(name);
		System.out.println(student.get(0));
		System.out.println(student.size());
	}

	public void countStudent() {
		Long count = studentService.countStudent();
		System.out.println(count);
	}
}
