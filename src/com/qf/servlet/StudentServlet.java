package com.qf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.entity.Student;
import com.qf.service.StudentService;
import com.qf.service.StudentServiceImpl;

@WebServlet(urlPatterns={"/findAllStudent",
		"/toAddStudentPage","/addStudent",
		"/toUpdateStudentPage","/updateStudent",
		"/deleteStudent"})
public class StudentServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		//������ղ����ı�����ʽ
		req.setCharacterEncoding("utf-8");
		
		String url = req.getRequestURL().toString();
		
		if(url.endsWith("findAllStudent")) {    		//�б�ҳ��
			findAllStudent(req, resp);
		} else if(url.endsWith("toAddStudentPage")) {  	//���ҳ��
			toAddStudentPage(req, resp);
		} else if(url.endsWith("addStudent")) {			//���
			addStudent(req, resp);
		} else if(url.endsWith("toUpdateStudentPage")) { //�޸�ҳ��
			toUpdateStudentPage(req, resp);
		} else if(url.endsWith("updateStudent")) {		//�޸�
			updateStudent(req, resp);
		} else if(url.endsWith("deleteStudent")) {		//ɾ��
			deleteStudent(req, resp);
		} 
		
	}

	private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡ����
		int id = Integer.parseInt(req.getParameter("id"));
		
		//����ҵ��㴦������
		StudentService service = new StudentServiceImpl();
		service.deleteById(id);
		
		//�ض����б�ҳ��  findAllStudent
		resp.sendRedirect("findAllStudent");
	}

	private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡ����
		int id = Integer.parseInt(req.getParameter("id"));
		String code = req.getParameter("code");
		String realName = req.getParameter("realName");
		String gender = req.getParameter("gender");
		String password = req.getParameter("password");
		String birthday = req.getParameter("birthday");
		
		//��װ
		Student stu = new Student(id, code, realName, password, gender, birthday, "0");
		
		//����ҵ��㴦������
		StudentService service = new StudentServiceImpl();
		service.updateStduent(stu);
		
				
		//�ض����б�ҳ��  findAllStudent
		resp.sendRedirect("findAllStudent");
	}

	private void toUpdateStudentPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//���ղ���
		int id = Integer.parseInt(req.getParameter("id"));
		
		//����ҵ����ѯ����
		StudentService service = new StudentServiceImpl();
		Student stu = service.findById(id);
		
		//Я������ת�����޸�ҳ����л���
		req.setAttribute("stu", stu);
		req.getRequestDispatcher("student_update.jsp").forward(req, resp);
	}

	private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡ����
		String code = req.getParameter("code");
		String realName = req.getParameter("realName");
		String gender = req.getParameter("gender");
		String password = req.getParameter("password");
		String birthday = req.getParameter("birthday");
		
		//��װ
		Student stu= new Student(null, code, realName, password, gender, birthday, null);
		
		//����ҵ��㴦������
		StudentService service = new StudentServiceImpl();
		service.addStudent(stu);
						
		//�ض����б�ҳ��  findAllStudent
		resp.sendRedirect("findAllStudent");
	}

	private void toAddStudentPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ת�������ҳ��
		req.getRequestDispatcher("student_add.jsp").forward(req, resp);
	}

	private void findAllStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//���ղ���
		String code = req.getParameter("code");
		String realName = req.getParameter("realName");
		String gender = req.getParameter("gender");
		
		//��װ��ѯ����
		Student stu = new Student();
		stu.setCode(code);
		stu.setRealName(realName);
		stu.setGender(gender);
		
		//����ҵ����ѯ����
		StudentService service = new StudentServiceImpl();
		List<Student> list = service.findAll(stu);
		
				
		//Я������ת�����޸�ҳ�������ʾ
		req.setAttribute("stu", stu);  //��ѯ��������
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("student_list.jsp").forward(req, resp);
	}
	
}
