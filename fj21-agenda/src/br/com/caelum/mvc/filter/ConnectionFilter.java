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

import br.com.caelum.jdbc.ConnectionFactory;

@WebFilter("/*")
public class ConnectionFilter implements Filter {
	
	public void init(FilterConfig fConfig) throws ServletException {}
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			request.setAttribute("conn", connection);
			chain.doFilter(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
