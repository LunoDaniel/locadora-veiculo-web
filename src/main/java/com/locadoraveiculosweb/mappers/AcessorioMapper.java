package com.locadoraveiculosweb.mappers;

import java.util.List;

import javax.enterprise.inject.Model;

import org.mapstruct.Mapper;

import com.locadoraveiculosweb.modelo.Acessorio;
import com.locadoraveiculosweb.modelo.dtos.AcessorioDto;

@Model
@Mapper(componentModel = "cdi")
public interface AcessorioMapper {
	
	Acessorio toAcessorio(AcessorioDto dto);
	
	AcessorioDto toAcessorioDto(Acessorio entity);
	
	List<Acessorio> toAcessorios(AcessorioDto[] acessorios);
	
	List<Acessorio> toAcessorio(List<AcessorioDto> dtoList);
	
	List<AcessorioDto> toAcessorioDto(List<Acessorio> entityList);

}
