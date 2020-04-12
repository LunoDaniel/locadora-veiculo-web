package com.locadoraveiculosweb.mappers;

import java.util.List;

import javax.enterprise.inject.Model;

import org.mapstruct.Mapper;

import com.locadoraveiculosweb.modelo.Acessorio;
import com.locadoraveiculosweb.modelo.dtos.AcessorioDto;

@Model
@Mapper
public interface AcessorioMapper {
	
	Acessorio toAcessorio(AcessorioDto dto);
	AcessorioDto toAcessorioDto(Acessorio entity);
	
	List<Acessorio> toAcessorio(List<AcessorioDto> dto);
	List<AcessorioDto> toAcessorioDto(List<Acessorio> entity);

}
