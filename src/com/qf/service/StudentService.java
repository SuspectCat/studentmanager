package com.qf.service;

import java.util.List;

import com.qf.entity.Student;

public interface StudentService {

	/**
	 * ��ѯ
	 * @param stu
	 * @return
	 */
	List<Student> findAll(Student stu);
	
	/**
	 * ��¼
	 * @param code
	 * @param password
	 * @return
	 */
	Student login(String code, String password);
	
	
	/**
	 * 
	 * @param stu
	 */
	void addStudent(Student stu);
	
	/**
	 * ɾ��
	 * @param id
	 */
	void deleteById(int id);
	
	/**
	 * ��������id,��ѯһ����¼
	 * @param id
	 * @return
	 */
	Student findById(int id);
	
	/**
	 * ��������id,�޸�һ����¼
	 * @param stu
	 */
	void updateStduent(Student stu);
	
}
