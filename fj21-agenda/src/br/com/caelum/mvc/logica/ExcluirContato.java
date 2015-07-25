package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;


public class ExcluirContato implements Logica {

	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		
    	Connection conn = (Connection) req.getAttribute("conn");
    	
    	ContatoDao dao = new ContatoDao(conn);
    	dao.remove(id);
    	
    	return "home.jsp";
		
	}
    

}
