package br.com.caelum.tarefas.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.modelo.Tarefa;

@Repository
public class JpaTarefaDAO implements TarefaDao{
	
	@PersistenceContext
	private EntityManager manager;

	public void adiciona(Tarefa t){
		manager.persist(t);
	}

	public void altera(Tarefa tarefa) {
		manager.merge(tarefa);
	}

	public List<Tarefa> lista() {
		return manager.createQuery("select t from Tarefa t").getResultList();
	}

	public Tarefa buscaPorId(Long id) {
		return manager.find(Tarefa.class, id);
	}

	public void remove(Tarefa tarefa) {
		Tarefa tarefaARemover = buscaPorId(tarefa.getId());
		
		manager.remove(tarefaARemover);
	}

	public void finaliza(Long id) {
		Tarefa tarefa = buscaPorId(id);
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(Calendar.getInstance());
		manager.merge(tarefa);
	}
}
