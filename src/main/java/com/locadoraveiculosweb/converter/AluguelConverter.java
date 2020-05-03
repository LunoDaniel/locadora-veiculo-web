package com.locadoraveiculosweb.converter;

import static java.util.Optional.ofNullable;

import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.locadoraveiculosweb.modelo.dtos.AluguelDto;
import com.locadoraveiculosweb.service.AluguelService;
import com.locadoraveiculosweb.service.Service;

import lombok.Getter;

@Getter
@FacesConverter(forClass = AluguelDto.class)
public class AluguelConverter extends BeanConverter<AluguelDto> {
	
	@Inject
	private AluguelService service;

	@Override
	protected String getValue(AluguelDto value) {
		return String.valueOf(ofNullable(value.getCodigo()).orElse(null));
	}

	@Override
	protected Service<AluguelDto> getService() {
		return service;
	}

}
