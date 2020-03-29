package com.locadoraveiculosweb.converter;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

import java.util.Optional;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.locadoraveiculosweb.modelo.dtos.AcessorioDto;
import com.locadoraveiculosweb.service.AcessorioService;

import lombok.Getter;

@Getter
@FacesConverter(forClass = AcessorioDto.class)
public class AcessorioConverter extends BeanConverter<AcessorioDto>  {

	@Inject
	private AcessorioService acessorioService;
	
	public AcessorioDto getAsObject(FacesContext context, UIComponent component, String value) {
		return this.acessorioService.buscarPeloCodigo(value);
	}

	public String getAsString(FacesContext context, UIComponent component, AcessorioDto value) {
		return (isNotEmpty(value)) ? getValue(value) : StringUtils.EMPTY;
	}
	
	@Override
	protected String getValue(AcessorioDto value) {
		return Optional.of(Optional.ofNullable(value.getCodigo()).toString()).orElse(null);
	}

}