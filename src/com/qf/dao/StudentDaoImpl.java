package com.qf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qf.entity.Student;
import com.qf.util.DbUtils;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> findAll(Student stu) {
		
		List<Student> list = new ArrayList<Student>();
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			
			conn = DbUtils.getConnection();
			stm = DbUtils.getStatement(conn);
			
			StringBuilder sf = new StringBuilder();
			sf.append("SELECT * FROM student ");
			sf.append("WHERE `status`=0 ");
			if(stu.getCode() != null && stu.getCode()!="") {
				sf.append("AND `code` LIKE '%"+stu.getCode()+"%' ");
			}
			if(stu.getRealName()!= null && stu.getRealName()!= "") {
				sf.append("AND real_name LIKE '%"+stu.getRealName()+"%' ");
			}
			if(stu.getGender()!= null && stu.getGender()!= "") {
				sf.append("AND gender = "+stu.getGender());
			}
			
			rs = stm.executeQuery(sf.toString());
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String code = rs.getString("code");
				String realName = rs.getString("real_name");
				String password = rs.getString("password");
				String birthday = rs.getString("birthday");
				String gender = rs.getString("gender");
				String status = rs.getString("status");
				
				Student student = new Student(id, code, realName, password, gender, birthday, status);
				list.add(student);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(conn, stm, rs);
		}
		
		return list;
	}

	@Override
	public Student findByCodeAndPwd(String code, String password) {
		
		Student student = null;
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			
			conn = DbUtils.getConnection();
			String sql = "SELECT * FROM student WHERE `status`=0 AND `code` =? AND `password` =?";
			PreparedStatement pstm = DbUtils.getPreparedStatement(conn, sql);
			pstm.setString(1, code);
			pstm.setString(2, password);
			
			rs = pstm.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String realName = rs.getString("real_name");
				String birthday = rs.getString("birthday");
				String gender = rs.getString("gender");
				String status = rs.getString("status");
				
				student = new Student(id, code, realName, password, gender, birthday, status);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(conn, stm, rs);
		}
		
		return student;
	}

	@Override
	public void addStudent(Student stu) {
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			conn = DbUtils.getConnection();
			String sql = "INSERT INTO student VALUES(NULL,?,?,?,?,?,0)";
			PreparedStatement pstm = DbUtils.getPreparedStatement(conn, sql);
			pstm.setString(1, stu.getCode());
			pstm.setString(2, stu.getRealName());
			pstm.setString(3, stu.getPassword());
			pstm.setString(4, stu.getGender());
			pstm.setString(5, stu.getBirthday());
			
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(conn, stm, rs);
		}
	}

	@Override
	public void deleteById(int id) {
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			conn = DbUtils.getConnection();
			String sql = "UPDATE student SET `status` =1 WHERE id = ?";
			PreparedStatement pstm = DbUtils.getPreparedStatement(conn, sql);
			pstm.setInt(1, id);
			pstm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(conn, stm, rs);
		}
	}

	@Override
	public Student findById(int id) {
		
		Student student = null;
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			
			conn = DbUtils.getConnection();
			String sql = "SELECT * FROM student WHERE id = ?";
			PreparedStatement pstm = DbUtils.getPreparedStatement(conn, sql);
			pstm.setInt(1, id);
			
			rs = pstm.executeQuery();
			while(rs.next()) {
				String code = rs.getString("code");
				String realName = rs.getString("real_name");
				String password = rs.getString("password");
				String birthday = rs.getString("birthday");
				String gender = rs.getString("gender");
				String status = rs.getString("status");
				
				student = new Student(id, code, realName, password, gender, birthday, status);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(conn, stm, rs);
		}
		
		return student;
	}

	@Override
	public void updateStduent(Student stu) {
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			conn = DbUtils.getConnection();
			StringBuilder sf = new StringBuilder();
			sf.append("UPDATE student ");
			sf.append("SET `code`=?,real_name=?, ");
			sf.append("`password`=?,gender=?,birthday=?, ");
			sf.append("`status`=? WHERE id = ? ");
			
			PreparedStatement pstm = DbUtils.getPreparedStatement(conn, sf.toString());
			pstm.setString(1, stu.getCode());
			pstm.setString(2, stu.getRealName());
			pstm.setString(3, stu.getPassword());
			pstm.setString(4, stu.getGender());
			pstm.setString(5, stu.getBirthday());
			pstm.setString(6, stu.getStatus());
			pstm.setInt(7, stu.getId());
			
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(conn, stm, rs);
		}
	}

}
