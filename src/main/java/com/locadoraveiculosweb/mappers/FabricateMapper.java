package com.locadoraveiculosweb.mappers;

import java.util.List;

import javax.enterprise.inject.Model;

import org.mapstruct.Mapper;

import com.locadoraveiculosweb.modelo.Fabricante;
import com.locadoraveiculosweb.modelo.dtos.FabricanteDto;

@Model
@Mapper
public interface FabricateMapper {
	
	Fabricante toFabricante(FabricanteDto dto);
	FabricanteDto toFabricanteDto(Fabricante entity);
	
	List<Fabricante> toFabricante(List<FabricanteDto> dto);
	List<FabricanteDto> toFabricanteDto(List<Fabricante> entity);

}
