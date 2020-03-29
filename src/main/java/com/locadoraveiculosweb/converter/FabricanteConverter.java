package com.locadoraveiculosweb.converter;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.EMPTY;

import java.util.Optional;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.locadoraveiculosweb.modelo.dtos.FabricanteDto;
import com.locadoraveiculosweb.service.FabricanteService;

import lombok.Getter;

@Getter
@FacesConverter(forClass = FabricanteDto.class)
public class FabricanteConverter extends BeanConverter<FabricanteDto> {

	@Inject
	private FabricanteService service;

	public FabricanteDto getAsObject(FacesContext context, UIComponent component, String value) {
		return service.buscarPeloCodigo(value);
	}

	public String getAsString(FacesContext context, UIComponent component, FabricanteDto value) {
		return (isNotEmpty(value)) ? getValue(value) : EMPTY;
	}

	@Override
	protected String getValue(FabricanteDto value) {
		return Optional.of(Optional.ofNullable(value.getCodigo()).toString()).orElse(null);
	}
}