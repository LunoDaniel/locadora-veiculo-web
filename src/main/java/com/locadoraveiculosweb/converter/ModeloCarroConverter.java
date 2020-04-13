package com.locadoraveiculosweb.converter;

import static java.util.Optional.ofNullable;

import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.locadoraveiculosweb.modelo.dtos.ModeloCarroDto;
import com.locadoraveiculosweb.service.ModeloCarroService;
import com.locadoraveiculosweb.service.Service;

import lombok.Getter;

@Getter
@FacesConverter(forClass=ModeloCarroDto.class)
public class ModeloCarroConverter extends BeanConverter<ModeloCarroDto> {

	@Inject
	private ModeloCarroService modeloCarroService;

	@Override
	protected String getValue(ModeloCarroDto value) {
		return String.valueOf(ofNullable(value.getCodigo()).orElse(null));
	}

	@Override
	protected Service<ModeloCarroDto> getService() {
		return modeloCarroService;
	}

}