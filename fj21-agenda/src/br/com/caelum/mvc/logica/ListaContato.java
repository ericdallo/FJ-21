package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;

public class ListaContato implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Connection conn = (Connection) req.getAttribute("conn");
    	ContatoDao dao = new ContatoDao(conn);
		req.setAttribute("lista", dao.getLista());
		return "jsp/lista-contato.jsp";
	}

}
