package com.qf.entity;

import java.io.Serializable;

public class Student implements Serializable {

	private Integer id;
	
	private String code;
	
	private String realName;
	
	private String password;
	
	private String gender;
	
	private String birthday;
	
	private String status;
	
	public Student() {
		
	}

	public Student(Integer id, String code, String realName, String password, String gender, String birthday,
			String status) {
		super();
		this.id = id;
		this.code = code;
		this.realName = realName;
		this.password = password;
		this.gender = gender;
		this.birthday = birthday;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
