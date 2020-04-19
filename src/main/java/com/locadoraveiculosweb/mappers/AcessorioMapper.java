package com.locadoraveiculosweb.mappers;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.inject.Model;

import org.mapstruct.Mapper;

import com.locadoraveiculosweb.modelo.Acessorio;
import com.locadoraveiculosweb.modelo.dtos.AcessorioDto;

@Model
@Mapper(componentModel = "cdi")
public interface AcessorioMapper {
	
	Acessorio toAcessorio(AcessorioDto dto);
	AcessorioDto toAcessorioDto(Acessorio entity);
	
	default List<Acessorio> toAcessorio(List<AcessorioDto> dtoList) {
		return dtoList.stream().map(dto -> toAcessorio(dto)).collect(Collectors.toList());
	}
	
	default List<AcessorioDto> toAcessorioDto(List<Acessorio> entityList) {
		return entityList.stream().map(entity -> toAcessorioDto(entity)).collect(Collectors.toList());
	}

}
