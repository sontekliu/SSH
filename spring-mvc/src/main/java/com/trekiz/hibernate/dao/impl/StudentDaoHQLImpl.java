package com.trekiz.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trekiz.hibernate.bean.Student;
import com.trekiz.hibernate.dao.StudentDao;

@Repository
public class StudentDaoHQLImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Student findStudentById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Student where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		return (Student) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findStudentByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Student where name = :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		return query.list();
	}

	@Override
	public Student findStudentSomeAttr(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select new Student(code,name,address) from Student where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		return (Student) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findStudentSomeAttr(String name) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select new Student(code,name,address) from Student where name = :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		return query.list();
	}

	@Override
	public Long countStudent() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select count(*) as count from Student";
		Query query = session.createQuery(sql);
		//返回值为Long类型
		return (Long)query.iterate().next();
	}

	@Override
	public void save(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.save(student);
	}

}
