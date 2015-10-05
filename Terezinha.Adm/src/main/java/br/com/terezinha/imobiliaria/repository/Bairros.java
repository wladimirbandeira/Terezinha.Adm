package br.com.terezinha.imobiliaria.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.terezinha.imobiliaria.model.Bairro;
import br.com.terezinha.imobiliaria.model.Cidade;

public class Bairros implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<Bairro> porCidade(Cidade cidade) {
		return manager.createQuery("from Bairro b where b.cidade =:cidade", Bairro.class).setParameter("cidade", cidade)
				.getResultList();

	}

}
