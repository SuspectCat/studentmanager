package com.qf.dao;

import java.util.List;

import com.qf.entity.Student;

public interface StudentDao {

	/**
	 * 查询
	 * @param stu
	 * @return
	 */
	List<Student> findAll(Student stu);
	
	/**
	 * 根据学号和密码查询
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
	 * 删除
	 * @param id
	 */
	void deleteById(int id);
	
	/**
	 * 根据主键id,查询一条记录
	 * @param id
	 * @return
	 */
	Student findById(int id);
	
	/**
	 * 根据主键id,修改一条记录
	 * @param stu
	 */
	void updateStduent(Student stu);
	
	
}
