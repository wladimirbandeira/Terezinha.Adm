package br.com.terezinha.imobiliaria.services;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.terezinha.imobiliaria.model.Cidade;
import br.com.terezinha.imobiliaria.repository.Cidades;
import br.com.terezinha.imobiliaria.util.jpa.Transactional;

public class CadastroCidadeService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private Cidades cidades;
	
	
	@Transactional
	public  Cidade salvar(Cidade cidade){
		return cidades.guardar(cidade);
	}
	


	
}
