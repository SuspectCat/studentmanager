package com.qf.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns={"/*"})
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURL().toString();
		
		//放行登录，跳转到页面请求
		if(url.endsWith("login") || url.endsWith("toLogin")) {
			chain.doFilter(request, response);
			return;
		}
		
		//获取session
		HttpSession session = req.getSession();
		
		//判断session中有无当前用户对象
		if(session.getAttribute("currentStu") == null) { //没登录
			req.setAttribute("msg", "没有权限，请求联系管理员");
			req.getRequestDispatcher("login.jsp").forward(req, response);
			return;
		}
		
		//over
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
