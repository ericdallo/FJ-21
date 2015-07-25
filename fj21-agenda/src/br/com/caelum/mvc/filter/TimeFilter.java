package br.com.caelum.mvc.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.jdbc.ConnectionFactory;

/**
 * Servlet Filter implementation class TimeFilter
 */
@WebFilter("/123")
public class TimeFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long inicio = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long fim = System.currentTimeMillis();
		String uri = ((HttpServletRequest) request).getRequestURI();
		String param = ((HttpServletRequest) request).getParameter("logica");
		
		System.out.println("Tempo de requisição da : "+ uri+"?logica="+param+" demorou (ms): " + (fim-inicio) + "\n");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
