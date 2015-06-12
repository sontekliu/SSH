package com.trekiz.hibernate.dao;

import java.util.List;

import com.trekiz.hibernate.bean.Student;

public interface StudentDao{

	/**
	 * 查询单个对象
	 * @param id
	 * @return
	 */
	public Student findStudentById(Integer id);
	
	/**
	 * 查询多个对象
	 * @param id
	 * @return
	 */
	public List<Student> findStudentByName(String name);
	
	/**
	 * 查询单个对象的某些字段
	 * @param id
	 * @return
	 */
	public Student findStudentSomeAttr(Integer id);
	
	/**
	 * 查询单个对象的某些字段
	 * @param id
	 * @return
	 */
	public List<Student> findStudentSomeAttr(String name);
	
	/**
	 * 查询总数
	 * @return
	 */
	public Long countStudent();
	
	/**
	 * 保存用户对象
	 * @param t
	 * @return
	 */
	public void save(Student student);
}
