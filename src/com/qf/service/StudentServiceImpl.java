package com.qf.service;

import java.util.List;

import com.qf.dao.StudentDao;
import com.qf.dao.StudentDaoImpl;
import com.qf.entity.Student;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> findAll(Student stu) {
		StudentDao dao = new StudentDaoImpl();
		return dao.findAll(stu);
	}

	@Override
	public Student login(String code, String password) {
		StudentDao dao = new StudentDaoImpl();
		return dao.findByCodeAndPwd(code, password);
	}

	@Override
	public void addStudent(Student stu) {
		StudentDao dao = new StudentDaoImpl();
		dao.addStudent(stu);
	}

	@Override
	public void deleteById(int id) {
		StudentDao dao = new StudentDaoImpl();
		dao.deleteById(id);
		
	}

	@Override
	public Student findById(int id) {
		StudentDao dao = new StudentDaoImpl();
		return dao.findById(id);
	}

	@Override
	public void updateStduent(Student stu) {
		StudentDao dao = new StudentDaoImpl();
		dao.updateStduent(stu);
	}

}
