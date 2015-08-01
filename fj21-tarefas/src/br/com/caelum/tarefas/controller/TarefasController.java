package br.com.caelum.tarefas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {
	
	@Autowired
	private JdbcTarefaDao dao;

	@RequestMapping("novaTarefa")
	public String form(Model model) {
		List<Tarefa> tarefas = dao.lista();
		model.addAttribute("tarefas", tarefas);
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa,BindingResult result,Model model) {
		if(result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}  
		dao.adiciona(tarefa);
		model.addAttribute("st",1);
		return "redirect:novaTarefa";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa,Model model) {
	  dao.remove(tarefa);
	  model.addAttribute("st", 2);
	  return "redirect:novaTarefa";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
	  model.addAttribute("tarefa", dao.buscaPorId(id));
	  return "tarefa/altera";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
	  dao.altera(tarefa);
	  return "redirect:novaTarefa";
	}
	
	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, Model model) {
	  dao.finaliza(id);
	  model.addAttribute("tarefa", dao.buscaPorId(id));
	  return "tarefa/finalizada";
	}
}
