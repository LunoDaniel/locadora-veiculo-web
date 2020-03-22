package com.algaworks.aluguelveiculos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.algaworks.aluguelveiculos.dao.ModeloCarroDAO;
import com.algaworks.aluguelveiculos.modelo.ModeloCarro;

@FacesConverter(forClass=ModeloCarro.class)
public class ModeloCarroConverter implements Converter<ModeloCarro> {

	@Inject
	private ModeloCarroDAO modeloCarroDAO;

	public ModeloCarro getAsObject(FacesContext context, UIComponent component, String value) {
		ModeloCarro retorno = null;

		if (value != null) {
			retorno = this.modeloCarroDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	public String getAsString(FacesContext context, UIComponent component, ModeloCarro value) {
		if (value != null) {
			Long codigo = value.getCodigo();
			return codigo == null ? null : codigo.toString();
		}
		return "";
	}

}