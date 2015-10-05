package br.com.terezinha.imobiliaria.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.terezinha.imobiliaria.model.Cidade;
import br.com.terezinha.imobiliaria.repository.Cidades;
import br.com.terezinha.imobiliaria.services.CadastroCidadeService;
import br.com.terezinha.imobiliaria.util.FacesUtil;

@Named
@ViewScoped
public class CadastroCidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cidade cidade;

	
	@Inject
	private CadastroCidadeService cadastroCidadeService;
	

	@Inject
	private Cidades cidades;

	public CadastroCidadeBean() {
		cidade = new Cidade();
	}

//	public void inicializar() {
//		System.out.println("iniciaando ........");
//		if (FacesUtil.isNotPostback()) {
//			todasCidades = cidades.raizesC();
//		}
//	}
//	
	
	public void salvar(){
		this.cidade = cadastroCidadeService.salvar(cidade);
		FacesUtil.addInfoMessage("Cidade salvo com sucesso");
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}


	public Cidades getCidades() {
		return cidades;
	}

	public void setCidades(Cidades cidades) {
		this.cidades = cidades;
	}

}
