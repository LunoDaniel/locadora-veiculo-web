package com.locadoraveiculosweb.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.locadoraveiculosweb.modelo.Fabricante;
import com.locadoraveiculosweb.modelo.dtos.FabricanteDto;

@Mapper
public interface FabricateMapper {
	
	Fabricante toFabricante(FabricanteDto dto);
	FabricanteDto toFabricanteDto(Fabricante entity);
	
	List<Fabricante> toFabricante(List<FabricanteDto> dto);
	List<FabricanteDto> toFabricanteDto(List<Fabricante> entity);

}
