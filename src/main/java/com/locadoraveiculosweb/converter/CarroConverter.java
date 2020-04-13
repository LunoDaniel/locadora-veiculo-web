package com.locadoraveiculosweb.converter;

import static java.util.Optional.ofNullable;

import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.locadoraveiculosweb.modelo.dtos.CarroDto;
import com.locadoraveiculosweb.service.CarroService;
import com.locadoraveiculosweb.service.Service;

import lombok.Getter;

@Getter
@FacesConverter(forClass = CarroDto.class)
public class CarroConverter extends BeanConverter<CarroDto> {
	
	@Inject
	private CarroService carroService;

	@Override
	protected Service<CarroDto> getService() {
		return carroService;
	}

	@Override
	protected String getValue(CarroDto value) {
		return String.valueOf(ofNullable(value.getCodigo()).orElse(null));
	}

}
