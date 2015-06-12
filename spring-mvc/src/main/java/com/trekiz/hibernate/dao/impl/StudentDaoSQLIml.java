package com.trekiz.hibernate.dao.impl;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trekiz.hibernate.bean.Student;
import com.trekiz.hibernate.dao.StudentDao;

@Repository
public class StudentDaoSQLIml implements StudentDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Student findStudentById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select * from t_student where id = :id";
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(Student.class);
		sqlQuery.setParameter("id", id);
		return (Student) sqlQuery.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findStudentByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select * from t_student where name = :name";
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(Student.class);
		sqlQuery.setParameter("name", name);
		return sqlQuery.list();
	}
	
	@Override
	public void save(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.save(student);
	}

	@Override
	public Long countStudent() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select count(*) as count from t_student";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		return ((BigInteger)sqlQuery.uniqueResult()).longValue();
	}

	@Override
	public Student findStudentSomeAttr(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select code,name,address,id,birth_date,card_id from t_student where id = :id";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setParameter("id", id);
		Object[] array = (Object[])sqlQuery.uniqueResult();
		Student stu = new Student();
		for (int i=0;i<array.length;i++) {
			stu.setCode(String.valueOf(array[0]));
			stu.setName(String.valueOf(array[1]));
			stu.setAddress(String.valueOf(array[2]));
			stu.setId(Integer.parseInt(String.valueOf(array[3])));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				stu.setBirthDate(sdf.parse(String.valueOf(array[4])));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			stu.setCardId(String.valueOf(array[5]));
		}
		return stu;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findStudentSomeAttr(String name) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select code,name,address,id,birth_date,card_id from t_student where name = :name";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setParameter("name", name);
		List<Object[]> list = sqlQuery.list();
		List<Student> listStu = new ArrayList<Student>();
		for (Object[] array:list) {
			Student stu = new Student();
			for (int i=0;i<array.length;i++) {
				stu.setCode(String.valueOf(array[0]));
				stu.setName(String.valueOf(array[1]));
				stu.setAddress(String.valueOf(array[2]));
				stu.setId(Integer.parseInt(String.valueOf(array[3])));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					stu.setBirthDate(sdf.parse(String.valueOf(array[4])));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				stu.setCardId(String.valueOf(array[5]));
			}
			listStu.add(stu);
		}
		return listStu;
	}
}
