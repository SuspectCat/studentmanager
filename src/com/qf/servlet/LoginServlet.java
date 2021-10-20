package com.qf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qf.entity.Student;
import com.qf.service.StudentService;
import com.qf.service.StudentServiceImpl;

@WebServlet(urlPatterns={"/login","/logout","/toLogin"})
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		
		if(url.endsWith("login")) {    			//��¼
			login(req, resp);
		} else if(url.endsWith("logout")) {  	//�ǳ�
			logout(req, resp);
		} else if(url.endsWith("toLogin")) {  	//��ת����¼ҳ��
			toLogin(req, resp);
		}
	}

	
	private void toLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	

	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ����
		String code = req.getParameter("code");
		String password = req.getParameter("password");
		
		//����ҵ��㴦������
		StudentService service = new StudentServiceImpl();
		Student stu = service.login(code, password);
		
		//���ݽ�������д���  ����ֱ���ض����б�ҳ��
		if(stu != null) {
			//�����¼�ɹ����ѵ�ǰ�û��Ķ��󣬷ŵ�session��
			HttpSession session = req.getSession();
			session.setAttribute("currentStu", stu);
			
			//�ض����б�ҳ��  findAllStudent
			resp.sendRedirect("findAllStudent");
		} else {
			req.setAttribute("msg", "�û������������");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
	}

	private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ֱ�Ӹ���
		HttpSession session = req.getSession();
		session.invalidate();
		//ת������¼ҳ��
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
}
