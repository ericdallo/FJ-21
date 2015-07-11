package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;


@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
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
			return;
		}
        
        Contato c = new Contato();
        c.setNome(nome);
        c.setEmail(email);
        c.setEndereco(endereco);
        c.setDataNascimento(dataNascimento);
        
        ContatoDao dao = new ContatoDao();
        dao.adiciona(c);
        
        out.println("<html>");
        out.println("<body>");
        out.println("Contato " + c.getNome() + " adcionado com sucesso");
        out.println("</body>");
        out.println("</html>");
        
    }

}
