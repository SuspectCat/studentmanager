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
		//定义接收参数的编码形式
		req.setCharacterEncoding("utf-8");
		
		String url = req.getRequestURL().toString();
		
		if(url.endsWith("findAllStudent")) {    		//列表页面
			findAllStudent(req, resp);
		} else if(url.endsWith("toAddStudentPage")) {  	//添加页面
			toAddStudentPage(req, resp);
		} else if(url.endsWith("addStudent")) {			//添加
			addStudent(req, resp);
		} else if(url.endsWith("toUpdateStudentPage")) { //修改页面
			toUpdateStudentPage(req, resp);
		} else if(url.endsWith("updateStudent")) {		//修改
			updateStudent(req, resp);
		} else if(url.endsWith("deleteStudent")) {		//删除
			deleteStudent(req, resp);
		} 
		
	}

	private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取参数
		int id = Integer.parseInt(req.getParameter("id"));
		
		//调用业务层处理请求
		StudentService service = new StudentServiceImpl();
		service.deleteById(id);
		
		//重定向到列表页面  findAllStudent
		resp.sendRedirect("findAllStudent");
	}

	private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取参数
		int id = Integer.parseInt(req.getParameter("id"));
		String code = req.getParameter("code");
		String realName = req.getParameter("realName");
		String gender = req.getParameter("gender");
		String password = req.getParameter("password");
		String birthday = req.getParameter("birthday");
		
		//封装
		Student stu = new Student(id, code, realName, password, gender, birthday, "0");
		
		//调用业务层处理请求
		StudentService service = new StudentServiceImpl();
		service.updateStduent(stu);
		
				
		//重定向到列表页面  findAllStudent
		resp.sendRedirect("findAllStudent");
	}

	private void toUpdateStudentPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//接收参数
		int id = Integer.parseInt(req.getParameter("id"));
		
		//调用业务层查询数据
		StudentService service = new StudentServiceImpl();
		Student stu = service.findById(id);
		
		//携带数据转发到修改页面进行回显
		req.setAttribute("stu", stu);
		req.getRequestDispatcher("student_update.jsp").forward(req, resp);
	}

	private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取参数
		String code = req.getParameter("code");
		String realName = req.getParameter("realName");
		String gender = req.getParameter("gender");
		String password = req.getParameter("password");
		String birthday = req.getParameter("birthday");
		
		//封装
		Student stu= new Student(null, code, realName, password, gender, birthday, null);
		
		//调用业务层处理请求
		StudentService service = new StudentServiceImpl();
		service.addStudent(stu);
						
		//重定向到列表页面  findAllStudent
		resp.sendRedirect("findAllStudent");
	}

	private void toAddStudentPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//转发到添加页面
		req.getRequestDispatcher("student_add.jsp").forward(req, resp);
	}

	private void findAllStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//接收参数
		String code = req.getParameter("code");
		String realName = req.getParameter("realName");
		String gender = req.getParameter("gender");
		
		//封装查询条件
		Student stu = new Student();
		stu.setCode(code);
		stu.setRealName(realName);
		stu.setGender(gender);
		
		//调用业务层查询数据
		StudentService service = new StudentServiceImpl();
		List<Student> list = service.findAll(stu);
		
				
		//携带数据转发到修改页面进行显示
		req.setAttribute("stu", stu);  //查询条件回显
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("student_list.jsp").forward(req, resp);
	}
	
}
