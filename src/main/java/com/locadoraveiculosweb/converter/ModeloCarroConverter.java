package com.locadoraveiculosweb.converter;

import java.util.Optional;

import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.locadoraveiculosweb.modelo.dtos.ModeloCarroDto;
import com.locadoraveiculosweb.service.ModeloCarroService;
import com.locadoraveiculosweb.service.Service;

@FacesConverter(forClass=ModeloCarroDto.class)
public class ModeloCarroConverter extends BeanConverter<ModeloCarroDto> {

	@Inject
	private ModeloCarroService modeloCarroService;

	@Override
	protected String getValue(ModeloCarroDto value) {
		return Optional.of(Optional.ofNullable(value.getCodigo()).toString()).orElse(null);
	}

	@Override
	protected Service<ModeloCarroDto> getService() {
		return modeloCarroService;
	}

}