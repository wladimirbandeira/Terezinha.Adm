package br.com.terezinha.imobiliaria.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.terezinha.imobiliaria.model.Bairro;
import br.com.terezinha.imobiliaria.model.Cidade;
import br.com.terezinha.imobiliaria.model.Imovel;
import br.com.terezinha.imobiliaria.repository.Bairros;
import br.com.terezinha.imobiliaria.repository.Cidades;

@Named
@ViewScoped
public class CadastroImovelBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Imovel imovel;

	private Cidade cidade;

	private Bairro bairro;

	private List<Cidade> raizesCidades;
	private List<Bairro> bairroPorCidade;

	@Inject
	private Cidades cidades;

	@Inject
	private Bairros bairros;

	public CadastroImovelBean() {

	}

	public void onCidadeChange() {
		bairroPorCidade = null;
		if (cidade != null) {
			bairroPorCidade = bairros.porCidade(cidade);
		}
	}

	public void inicializar() {
		imovel = new Imovel();
		raizesCidades = cidades.raizesC();

	}

	public List<Cidade> getRaizesCidades() {
		return raizesCidades;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Bairro> getBairroPorCidade() {
		return bairroPorCidade;
	}

}
