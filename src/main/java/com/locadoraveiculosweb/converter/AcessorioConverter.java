package com.algaworks.aluguelveiculos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.algaworks.aluguelveiculos.dao.AcessorioDAO;
import com.algaworks.aluguelveiculos.modelo.Acessorio;

@FacesConverter("acessorioConverter")
public class AcessorioConverter implements Converter<Acessorio> {

	@Inject
	private AcessorioDAO acessorioDAO;
	
	public Acessorio getAsObject(FacesContext context, UIComponent component, String value) {
		Acessorio retorno = null;
		
		if (value != null) {
			retorno = this.acessorioDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	public String getAsString(FacesContext context, UIComponent component, Acessorio value) {
		if (value != null) {
			Long codigo = value.getCodigo();
			return  (codigo == null ? null : codigo.toString());
		}
		
		return "";
	}

}