package br.com.terezinha.imobiliaria.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.terezinha.imobiliaria.model.Cidade;
import br.com.terezinha.imobiliaria.repository.Cidades;
import br.com.terezinha.imobiliaria.util.cdi.CDIServiceLocator;


@FacesConverter(forClass = Cidade.class)
public class CidadeConverter implements Converter {

	private Cidades cidades;

	public CidadeConverter() {
		cidades = CDIServiceLocator.getBean(Cidades.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cidade retorno = null;
		if (value != null) {
			Long id = new Long(value);
			retorno = cidades.porId(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Cidade cidade = (Cidade) value;
			return cidade.getCodigo() == null ? null : cidade.getCodigo().toString();


		}

		return "";
	}

}
