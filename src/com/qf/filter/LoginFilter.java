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
		
		//���е�¼����ת��ҳ������
		if(url.endsWith("login") || url.endsWith("toLogin")) {
			chain.doFilter(request, response);
			return;
		}
		
		//��ȡsession
		HttpSession session = req.getSession();
		
		//�ж�session�����޵�ǰ�û�����
		if(session.getAttribute("currentStu") == null) { //û��¼
			req.setAttribute("msg", "û��Ȩ�ޣ�������ϵ����Ա");
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
