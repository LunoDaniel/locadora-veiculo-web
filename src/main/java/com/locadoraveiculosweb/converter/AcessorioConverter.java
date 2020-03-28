package com.locadoraveiculosweb.converter;

import java.util.Optional;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import com.locadoraveiculosweb.dao.AcessorioDAO;
import com.locadoraveiculosweb.modelo.Acessorio;

@FacesConverter("acessorioConverter")
public class AcessorioConverter implements Converter<Acessorio> {

	@Inject
	private AcessorioDAO acessorioDAO;
	
	public Acessorio getAsObject(FacesContext context, UIComponent component, String value) {
		Acessorio retorno = null;
		
		if (ObjectUtils.isNotEmpty(value)) {
			retorno = this.acessorioDAO.buscarPeloCodigo(Long.valueOf(value));
		}

		return retorno;
	}

	public String getAsString(FacesContext context, UIComponent component, Acessorio value) {
		
		if (ObjectUtils.isNotEmpty(value)) {
			
			return Optional.of(Optional.ofNullable(value.getCodigo()).toString()).orElse(null);
		}
		
		return StringUtils.EMPTY;
	}
	

}