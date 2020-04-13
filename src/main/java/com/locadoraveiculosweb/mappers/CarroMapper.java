package com.locadoraveiculosweb.mappers;

import java.util.List;

import javax.enterprise.inject.Model;

import org.mapstruct.Mapper;

import com.locadoraveiculosweb.modelo.Carro;
import com.locadoraveiculosweb.modelo.dtos.CarroDto;

@Model
@Mapper
public interface CarroMapper {
	
	Carro toCarro(CarroDto dto);
	CarroDto toCarroDto(Carro entity);
	
	List<Carro> toCarro(List<CarroDto> dto);
	List<CarroDto> toCarroDto(List<Carro> entity);

}
