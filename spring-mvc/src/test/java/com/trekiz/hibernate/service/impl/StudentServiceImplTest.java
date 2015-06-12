package com.trekiz.hibernate.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.trekiz.hibernate.bean.Student;
import com.trekiz.hibernate.service.StudentService;

@ContextConfiguration(locations = "classpath:applicationContext-common.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentServiceImplTest{

	@Resource
	private StudentService studentService;
	
	@Test
	public void save() {
		Student stu = new Student();
		stu.setCode("200801001010");
		stu.setName("王五");
		stu.setAge(24);
		stu.setSex("N");
		stu.setAddress("山东省济南市济阳县垛石镇建华村");
		stu.setCardId("370125198806013819");
		stu.setBirthDate(new Date());
		stu.setCreateBy(123);
		stu.setCreateDate(new Date());
		stu.setUpdateBy(123);
		stu.setUpdateDate(new Date());
		//Assert.assertNull(studentService);
		studentService.save(stu);
	}
	
	@Test
	public void findStudentById() {
		Student student = studentService.findStudentById(1);
		System.out.println(student.getAddress());
	}

	@Test
	public void findStudentByName() {
		List<Student> student = studentService.findStudentByName("刘世军");
		System.out.println(student.get(0).getAddress());
		System.out.println(student.size());
	}

	@Test
	public void countStudent() {
		Long count = studentService.countStudent();
		System.out.println(count);
	}
	
	@Test
	public void findSingleStudentSomeAttr(){
		Student student = studentService.findStudentSomeAttr(1);
		System.out.println(student.getCode());
	}
	@Test
	public void findStudentSomeAttr(){
		List<Student> student = studentService.findStudentSomeAttr("刘世军");
		System.out.println(student.get(0).getCode());
		System.out.println(student.size());
	}

}
