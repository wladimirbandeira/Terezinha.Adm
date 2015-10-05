package br.com.terezinha.imobiliaria.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.terezinha.imobiliaria.model.Cidade;

public class Cidades implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Cidade porId(Long id) {
		return manager.find(Cidade.class, id);

	}

	
	public List<Cidade> raizesC(){
		return manager.createQuery("from Cidade order by nome", Cidade.class).getResultList();
	}



	public Cidade guardar(Cidade cidade) {
		return manager.merge(cidade);
	}

	

}
