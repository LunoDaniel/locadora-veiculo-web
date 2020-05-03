package com.locadoraveiculosweb.mappers;

import java.util.List;

import javax.enterprise.inject.Model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.locadoraveiculosweb.modelo.Carro;
import com.locadoraveiculosweb.modelo.dtos.CarroDto;

@Model
@Mapper(componentModel = "cdi", uses = { AcessorioMapper.class, ModeloCarroMapper.class })
public interface CarroMapper {
	
	@Mapping(target="alugueis", ignore = true)
	Carro toCarro(CarroDto dto);
	
	@Mapping(target="alugueis", ignore = true)
	CarroDto toCarroDto(Carro entity);
	
	List<Carro> toCarro(List<CarroDto> dto);
	List<CarroDto> toCarroDto(List<Carro> entity);
	
}
