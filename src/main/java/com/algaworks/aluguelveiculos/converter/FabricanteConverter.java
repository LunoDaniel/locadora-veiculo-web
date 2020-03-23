package com.algaworks.aluguelveiculos.converter;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.algaworks.aluguelveiculos.dao.FabricanteDAO;
import com.algaworks.aluguelveiculos.modelo.Fabricante;

import lombok.Getter;

@Getter
@FacesConverter(forClass = Fabricante.class)
public class FabricanteConverter implements Converter<Fabricante> {

	@Inject
	private FabricanteDAO fabricanteDAO;

	public Fabricante getAsObject(FacesContext context, UIComponent component, String value) {
		Fabricante retorno = null;
		
		if (isNotBlank(value)) {
			retorno = this.fabricanteDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	public String getAsString(FacesContext context, UIComponent component, Fabricante value) {
		if (value != null) {
			Long codigo = value.getCodigo();
			return (codigo == null ? null : codigo.toString());
		}

		return "";
	}
}