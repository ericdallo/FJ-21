package br.com.caelum.mvc.logica;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class ReplaceContato implements Logica{
	private static final long serialVersionUID = 1L;
    

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		PrintWriter out = res.getWriter();
        
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String endereco = req.getParameter("endereco");
        String dataEmTexto = req.getParameter("dataNascimento");
        Calendar dataNascimento = null;
        
        try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
			
		} catch (ParseException e) {
			out.println("Erro de conversão da data");
			out.println("Insira uma data valida: dd/MM/yyyy");
			return "home.jsp";
		}
        
    	Connection conn = (Connection) req.getAttribute("conn");
    	ContatoDao dao = new ContatoDao(conn);
    	
        String id = req.getParameter("id");
        
        if(id == null){
        	Contato c = new Contato();
            c.setNome(nome);
            c.setEmail(email);
            c.setEndereco(endereco);
            c.setDataNascimento(dataNascimento);
            dao.adiciona(c);
            
            req.setAttribute("nome", c.getNome());
            return "jsp/contatoOk.jsp";
        }else{
        	Contato c = dao.getContato(Integer.parseInt(id));
            c.setNome(nome);
            c.setEmail(email);
            c.setEndereco(endereco);
            c.setDataNascimento(dataNascimento);
            dao.altera(c);
            
            req.setAttribute("nome", c.getNome());
            return "jsp/contato_alterado.jsp";
        }
        
        
	}

}
