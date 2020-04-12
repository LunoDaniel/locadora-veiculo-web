package com.locadoraveiculosweb.converter;

import java.util.Optional;

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
		return Optional.of(Optional.ofNullable(value.getCodigo()).toString()).orElse(null);
	}

	@Override
	protected Service<FabricanteDto> getService() {
		return fabricanteService;
	}
}