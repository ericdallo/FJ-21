package br.com.caelum.tarefas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		if(uri.contains("index") || uri.contains("login") || uri.contains("resources")){
			return true;
		}
		
		if (request.getSession().getAttribute("loggedUser") != null) {
			return true;
		}
		
		response.sendRedirect("index");
		return false;
	}
}
