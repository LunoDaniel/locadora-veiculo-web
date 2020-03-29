package com.locadoraveiculosweb.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.locadoraveiculosweb.modelo.Acessorio;
import com.locadoraveiculosweb.modelo.dtos.AcessorioDto;

@Mapper
public interface AcessorioMapper {
	
	Acessorio toAcessorio(AcessorioDto dto);
	AcessorioDto toAcessorioDto(Acessorio entity);
	
	List<Acessorio> toAcessorio(List<AcessorioDto> dto);
	List<AcessorioDto> toAcessorioDto(List<Acessorio> entity);

}
