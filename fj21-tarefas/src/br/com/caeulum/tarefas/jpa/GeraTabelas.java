package br.com.caeulum.tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class GeraTabelas {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("fj21");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.close();
		factory.close();
	}
}
