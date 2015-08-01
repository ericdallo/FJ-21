package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;

@Controller
public class LoginController {
	
	@Autowired
	private JdbcUsuarioDao dao;
	
	@RequestMapping("index")
	public String index(){
		return "tarefa/index";
	}
	
	
	@RequestMapping("login")
	public String login(Usuario u,HttpSession session){
		if(dao.existeUsuario(u)){
			session.setAttribute("loggedUser", u);
			return "redirect:novaTarefa";
		}
		return "redirect:index";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:index";
	}
}
