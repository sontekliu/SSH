package com.trekiz.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.trekiz.hibernate.bean.Student;
import com.trekiz.hibernate.dao.StudentDao;
import com.trekiz.hibernate.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	@Qualifier("studentDaoSQLIml")
	private StudentDao studentDao;

	@Override
	public Student findStudentById(Integer id) {
		return studentDao.findStudentById(id);
	}

	@Override
	public List<Student> findStudentByName(String name) {
		return studentDao.findStudentByName(name);
	}

	@Override
	public Student findStudentSomeAttr(Integer id) {
		return studentDao.findStudentSomeAttr(id);
	}

	@Override
	public List<Student> findStudentSomeAttr(String name) {
		return studentDao.findStudentSomeAttr(name);
	}

	@Override
	public Long countStudent() {
		return studentDao.countStudent();
	}

	@Override
	public void save(Student student) {
		studentDao.save(student);
	}
	
}
