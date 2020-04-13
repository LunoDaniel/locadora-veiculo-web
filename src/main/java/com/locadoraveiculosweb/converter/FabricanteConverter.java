package com.locadoraveiculosweb.converter;

import static java.util.Optional.ofNullable;

import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.locadoraveiculosweb.modelo.dtos.FabricanteDto;
import com.locadoraveiculosweb.service.FabricanteService;
import com.locadoraveiculosweb.service.Service;

import lombok.Getter;

@Getter
@FacesConverter(forClass = FabricanteDto.class)
public class FabricanteConverter extends BeanConverter<FabricanteDto> {

	@Inject
	private FabricanteService fabricanteService;

	@Override
	protected String getValue(FabricanteDto value) {
		return String.valueOf(ofNullable(value.getCodigo()).orElse(null));
	}

	@Override
	protected Service<FabricanteDto> getService() {
		return fabricanteService;
	}
}