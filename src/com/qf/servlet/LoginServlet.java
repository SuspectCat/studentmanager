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
		
		if(url.endsWith("login")) {    			//登录
			login(req, resp);
		} else if(url.endsWith("logout")) {  	//登出
			logout(req, resp);
		} else if(url.endsWith("toLogin")) {  	//跳转到登录页面
			toLogin(req, resp);
		}
	}

	
	private void toLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	

	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取参数
		String code = req.getParameter("code");
		String password = req.getParameter("password");
		
		//调用业务层处理请求
		StudentService service = new StudentServiceImpl();
		Student stu = service.login(code, password);
		
		//根据结果，进行处理  工程直接重定向到列表页面
		if(stu != null) {
			//如果登录成功，把当前用户的对象，放到session中
			HttpSession session = req.getSession();
			session.setAttribute("currentStu", stu);
			
			//重定向到列表页面  findAllStudent
			resp.sendRedirect("findAllStudent");
		} else {
			req.setAttribute("msg", "用户名或密码错误");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
	}

	private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//直接干死
		HttpSession session = req.getSession();
		session.invalidate();
		//转发到登录页面
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
}
