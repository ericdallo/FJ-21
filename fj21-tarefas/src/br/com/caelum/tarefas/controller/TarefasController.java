package br.com.caelum.tarefas.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.TarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Transactional
@Controller
public class TarefasController {
	
	@Autowired
	@Qualifier("jpaTarefaDAO")
	private TarefaDao dao;

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
