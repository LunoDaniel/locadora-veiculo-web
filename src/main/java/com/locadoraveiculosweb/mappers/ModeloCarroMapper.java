package com.locadoraveiculosweb.mappers;

import java.util.List;

import javax.enterprise.inject.Model;

import org.mapstruct.Mapper;

import com.locadoraveiculosweb.modelo.ModeloCarro;
import com.locadoraveiculosweb.modelo.dtos.ModeloCarroDto;

@Model
@Mapper
public interface ModeloCarroMapper {
	
	ModeloCarro toModeloCarro(ModeloCarroDto dto);
	ModeloCarroDto toModeloCarroDto(ModeloCarro entity);
	
	List<ModeloCarro> toModeloCarro(List<ModeloCarroDto> dto);
	List<ModeloCarroDto> toModeloCarroDto(List<ModeloCarro> entity);

}
