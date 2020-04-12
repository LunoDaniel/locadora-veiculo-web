package com.locadoraveiculosweb.converter;

import java.util.Optional;

import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.locadoraveiculosweb.modelo.dtos.AcessorioDto;
import com.locadoraveiculosweb.service.AcessorioService;
import com.locadoraveiculosweb.service.Service;

import lombok.Getter;

@Getter
@FacesConverter(forClass = AcessorioDto.class)
public class AcessorioConverter extends BeanConverter<AcessorioDto>  {

	@Inject
	private AcessorioService acessorioService;
	
	@Override
	protected String getValue(AcessorioDto value) {
		return Optional.of(Optional.ofNullable(value.getCodigo()).toString()).orElse(null);
	}

	@Override
	protected Service<AcessorioDto> getService() {
		return acessorioService;
	}

}