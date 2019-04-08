package com.running4light.gdms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.running4light.gdms.common.WebWords;
import com.running4light.gdms.pojo.Student;

public class SessionInterceptor implements HandlerInterceptor{

	private static final String[] IGNORE_URI = {"/userlogin","/login.html"};
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String servletPath = request.getServletPath();
		System.out.println(request.getContextPath());
		System.out.println(request.getRequestURI());
		System.out.println(request.getServletPath());
		boolean flag = false;
		for (String string : IGNORE_URI) {
			if(servletPath.contains(string)) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			Student student = (Student) request.getSession().getAttribute(WebWords.USERSESSION);
			if(student==null) {
				request.setAttribute("message","未登录！");
				request.getRequestDispatcher("/login.html").forward(request, response);
				return flag;
			}else {
				flag = true;
			}
		}
		return flag;
	}

}
