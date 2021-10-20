package com.qf.dao;

import java.util.List;

import com.qf.entity.Student;

public interface StudentDao {

	/**
	 * ��ѯ
	 * @param stu
	 * @return
	 */
	List<Student> findAll(Student stu);
	
	/**
	 * ����ѧ�ź������ѯ
	 * @param code
	 * @param password
	 * @return
	 */
	Student findByCodeAndPwd(String code, String password);
	
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
