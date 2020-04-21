package com.locadoraveiculosweb.converter;

import static java.util.Optional.ofNullable;

import javax.enterprise.inject.Model;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.locadoraveiculosweb.modelo.dtos.AcessorioDto;
import com.locadoraveiculosweb.service.AcessorioService;
import com.locadoraveiculosweb.service.Service;

import lombok.Getter;

@Getter
@Model
@FacesConverter(value = "acessorioConverter", forClass = AcessorioDto.class)
public class AcessorioConverter extends BeanConverter<AcessorioDto>  {

	@Inject
	private AcessorioService acessorioService;
	
	@Override
	protected String getValue(AcessorioDto value) {
		return String.valueOf(ofNullable(value.getCodigo()).orElse(null));
	}

	@Override
	protected Service<AcessorioDto> getService() {
		return acessorioService;
	}
}