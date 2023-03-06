package com.spring.orm.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.orm.hibernate5.HibernateTemplate;
import com.spring.orm.entities.Student;


public class StudentDao {

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int insert(Student student) {
		return (Integer) this.hibernateTemplate.save(student);
	}

	public Student getStudent(int studentId) {
		return this.hibernateTemplate.get(Student.class, studentId);
	}

	public List<Student> getStudents() {
		return this.hibernateTemplate.loadAll(Student.class);
	}

	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}

	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}

}
